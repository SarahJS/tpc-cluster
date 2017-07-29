import java.util.Hashtable;

public class RemoveOperation implements IWriteOperation {
	private String key;
	
	public RemoveOperation(String key) {
		this.key = key;
	}
	
	@Override
	public void Apply(Hashtable<String, String> hashtable) {
		hashtable.remove(this.key);
	}
}