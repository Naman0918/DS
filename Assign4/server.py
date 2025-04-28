import datetime
import socket
import time
import threading
from dateutil import parser

client_data = {}

def ss(coordinator, address):
    print(f"[+] New client connected from {address}")
    while True:
        try:
            date_time = coordinator.recv(1024).decode()
            dd = parser.parse(date_time)
            diff = datetime.datetime.now() - dd
            client_data[address] = {
                "connector":  coordinator,
                "datetime": dd,
                "differnece": diff
            }
            print(f"[{address}] Sent time: {dd} | Difference with server: {diff}")
        except Exception as e:
            print(f"[!] Error with client {address}: {e}")
            break
        time.sleep(5)

def getstart(master_slave):
    print("[*] Server is ready to accept connections...")
    while True:
        coordinator, addr = master_slave.accept()
        address = str(addr[0]) + ':' + str(addr[1])
        curr = threading.Thread(
            target=ss,
            args=(coordinator, address)
        )
        curr.start()
        time.sleep(5)

# def avgreg():
#     if len(client_data) == 0:
#         return datetime.timedelta()
#     total = sum((client['differnece'] for client in client_data.values()), datetime.timedelta())
#     avg = total / len(client_data)
#     print(f"Average time difference across clients: {avg}")
#     return avg

def synctime(master_slave):
    while True:
        if len(client_data) > 0:
            # avg = avgreg()
            for client_addr, client in client_data.items():
                try:
                    # tim = datetime.datetime.now() + avg
                    tim = datetime.datetime.now()
                    client['connector'].send(str(tim).encode())
                    print(f"[->] Sent synchronized time {tim} to client at {client_addr}")
                except Exception as e:
                    print(f"Failed to send time to {client_addr}: {e}")
        else:
            print("[!] No clients connected to synchronize.")
        time.sleep(5)

def start(port=8080):
    master_slave = socket.socket()
    # master_slave.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    master_slave.bind(('', port))
    master_slave.listen(10)
    print(f"Server started and listening on port {port}")

    current = threading.Thread(
        target=getstart,
        args=(master_slave,)
    )
    current.start()

    sync = threading.Thread(
        target=synctime,
        args=(master_slave,)
    )
    sync.start()


if __name__ == '__main__':
    start(port=8080)
