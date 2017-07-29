package secondary;
import java.rmi.*;

import keyValueStore.IWriteOperation;

public interface Secondary extends java.rmi.Remote {
	Boolean FirstPhase(IWriteOperation op) throws RemoteException;
	void SecondPhase(Boolean commit) throws RemoteException;
}