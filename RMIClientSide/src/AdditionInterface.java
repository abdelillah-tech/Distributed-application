import java.rmi.*;

public interface AdditionInterface extends Remote{
	public void niveaux(int n) throws RemoteException;
	public void budget(int bud) throws RemoteException;
	public void qualite(int n) throws RemoteException;
	public void pays(int n) throws RemoteException;
	public String[] informations() throws RemoteException;
	public String connec(boolean e) throws RemoteException;
	public String propose(int niv, int bud, int qual, int pay) throws RemoteException;
	public String confirmer(int niv, int bud, int qual, int pay) throws RemoteException;
	public Boolean draham() throws RemoteException;
}
