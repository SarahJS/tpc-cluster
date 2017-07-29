import java.rmi.*;

public interface Secondary extends java.rmi.Remote {
	Boolean FirstPhase(IWriteOperation op) throws RemoteException;
	void SecondPhase() throws RemoteException;
}