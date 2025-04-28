
import java.rmi.*;
import java.rmi.server.*;
//class that implements the remote interface

public class AddServerImpl extends UnicastRemoteObject
        implements AddServerIntf {
//constructor

    public AddServerImpl() throws RemoteException {
    }
//implement method declared in the interface

    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }

    public double sub(double d1, double d2) throws RemoteException {
        return d1 - d2;
    }

    public double mul(double d1, double d2) throws RemoteException {
        return d1 * d2;
    }

    public double div(double d1, double d2) throws RemoteException {
        if (d2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return d1 / d2;
    }

    public double pow(double d1, double d2) throws RemoteException {
        return Math.pow(d1, d2);
    }

    public double two_pow(double d1) throws RemoteException {
        return Math.pow(2, d1);
    }
    public double celsius_fahrenheit(double d1) throws RemoteException {
        return (d1 * 9/5) + 32;
    }
    public double miles_to_kilometer(double d1) throws RemoteException {
        return d1 * 1.60934;
    }
    public double factorial(double d1) throws RemoteException {
        if (d1 < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        double result = 1;
        for (int i = 1; i <= d1; i++) {
            result *= i;
        }
        return result;
    }



}
