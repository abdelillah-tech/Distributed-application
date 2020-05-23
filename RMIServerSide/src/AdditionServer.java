import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class AdditionServer {
	public static void main (String[] argv) {
		try {
			Addition Hello = new Addition();
			LocateRegistry.createRegistry(15000);
			Naming.rebind("rmi://127.0.0.1:15000/ABC", Hello);
			System.out.println("Bonjour je suis a votre disposition.");
		}catch (Exception e) {
			System.out.println("Desole le service est en panne " + e);
		}
	}
}
