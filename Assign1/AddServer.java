
import java.rmi.*;

public class AddServer {

    public static void main(String args[]) {
        try {
            
            AddServerImpl addServerImpl = new AddServerImpl(); //create remote object
            
            Naming.rebind("AddServer", addServerImpl); //bind the remote object 
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
