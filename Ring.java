package Assign_5;

import java.util.Scanner;

public class Ring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the ring: ");
        int n = sc.nextInt(); // total number of nodes
        int token = 0; // initially token at node 0

        // Print the ring nodes
        System.out.print("Ring Topology: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println(0); // to show ring back to start

        try {
            while (true) {
                System.out.print("\nEnter sender node: ");
                int sender = sc.nextInt();

                System.out.print("Enter receiver node: ");
                int receiver = sc.nextInt();

                System.out.print("Enter data to send: ");
                String data = sc.next();

                // Token moving to sender
                System.out.print("Token passing: ");
                int i = token;
                while (i != sender) {
                    System.out.print(i + " -> ");
                    i = (i + 1) % n;
                }
                System.out.println(sender);

                // Sender sends data
                System.out.println("Sender " + sender + " is sending data: " + data);

                // Data forwarding to receiver
                int current = (sender + 1) % n;
                while (current != receiver) {
                    System.out.println("Node " + current + " forwarding data: " + data);
                    current = (current + 1) % n;
                }

                // Receiver receives data
                System.out.println("Receiver " + receiver + " received data: " + data);

                // Token now at sender
                token = sender;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
