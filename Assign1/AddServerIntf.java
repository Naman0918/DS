import java.rmi.*;
public interface AddServerIntf extends Remote { 
//method declaration 
double add(double d1, double d2) throws RemoteException;
double sub(double d1, double d2) throws RemoteException;
double mul(double d1, double d2) throws RemoteException;
double div(double d1, double d2) throws RemoteException;
double pow(double d1, double d2) throws RemoteException;
double two_pow(double d1) throws RemoteException;
// Celsius to Fahrenheit Conversion 
double celsius_fahrenheit(double d1) throws RemoteException;
double miles_to_kilometer(double d1) throws RemoteException;
double factorial(double d1) throws RemoteException;
}
