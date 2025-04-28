
import java.rmi.*;
import java.util.Scanner;

public class AddClient {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {
// Get reference to the remote object
            String addServerURL = "rmi://localhost/AddServer";
            AddServerIntf AddServerIntf = (AddServerIntf) Naming.lookup(addServerURL);

            System.out.println("Enter first number : ");
            double d1 = sc.nextDouble();

            System.out.println("Enter second number: ");
            double d2 = sc.nextDouble();

            System.out.println("First number is: " + d1);
            System.out.println("Second number is: " + d2);

            System.out.println("-----Results:-----");
            System.out.println("The sum is: " + AddServerIntf.add(d1, d2));
            System.out.println("The difference is :" + AddServerIntf.sub(d1, d2));
            System.out.println("The product is :" + AddServerIntf.mul(d1, d2));
            System.out.println("The quotient is :" + AddServerIntf.div(d1, d2));
            System.out.println("The power is :" + AddServerIntf.pow(d1, d2));
            System.out.println("The two power is :" + AddServerIntf.two_pow(d1));
            System.out.println("celsius to fahrenheit is :"+ AddServerIntf.celsius_fahrenheit(d1));
            System.out.println(d1 + " Miles to Kilometer is: " + AddServerIntf.miles_to_kilometer(d1));
            System.out.println("The factorial of " + d1 + " is: " + AddServerIntf.factorial(d1));
            System.out.println("-----End of Results-----");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
