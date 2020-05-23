import java.rmi.*;

public interface AdditionInterface extends Remote{
	public void niveaux(int n) throws RemoteException;   //pour le test
	public void budget(int bud) throws RemoteException;  //pour le test
	public void qualite(int n) throws RemoteException;   //pour le test
	public void pays(int n) throws RemoteException;      //pour le test
	public String[] informations() throws RemoteException; 									//contient meteo, tarif, horaires et l'heure actuel
	public String connec(boolean e) throws RemoteException; 								//
	public String propose(int niv, int bud, int qual, int pay) throws RemoteException;      //propose les boutiques
	public String confirmer(int niv, int bud, int qual, int pay) throws RemoteException;    //retourne les les quatres informations separe par des ","
	public Boolean draham() throws RemoteException; 
}
