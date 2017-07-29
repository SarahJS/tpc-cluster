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
				this.localHashtable.put(key, value);
			}
		}
	}
	
	public void Remove(String key) {
		synchronized (this.lockObject) {
			IWriteOperation op = new RemoveOperation(key);
			if (this.TwoPhaseCommit(op))
			{
				this.localHashtable.remove(key);
			}
		}
	}
	
	private Boolean TwoPhaseCommit(IWriteOperation op) {
		return true;
	}
}