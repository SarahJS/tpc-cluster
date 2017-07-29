package keyValueStore;
import java.util.Hashtable;

public class TwoPhaseCommitKeyValueStore implements IKeyValueStore {
	private Hashtable<String, String> localHashtable = new Hashtable<String, String>();
	private Object lockObject = new Object();
	
	public String Get(String key) {
		synchronized (this.lockObject) {
			return this.localHashtable.get(key);
		}
	}
	
	public void Set(String key, String value) {
		synchronized (this.lockObject) {
			IWriteOperation op = new SetOperation(key, value);
			if (this.TwoPhaseCommit(op))
			{
				op.Apply(this.localHashtable);
			}
		}
	}
	
	public void Remove(String key) {
		synchronized (this.lockObject) {
			IWriteOperation op = new RemoveOperation(key);
			if (this.TwoPhaseCommit(op))
			{
				op.Apply(this.localHashtable);
			}
		}
	}
	
	private Boolean TwoPhaseCommit(IWriteOperation op) {
		return true;
		// send write operation to secondaries
		// wait for reply from all secondaries confirming receipt
		// send message to secondaries confirming all confirmed
	}
}