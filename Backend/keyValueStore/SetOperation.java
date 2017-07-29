package keyValueStore;
import java.util.Hashtable;

public class SetOperation implements IWriteOperation {
	private String key;
	private String value;
	
	public SetOperation(String key, String value)
	{
		this.key = key;
		this.value = value;
	}
	
	@Override
	public void Apply(Hashtable<String, String> hashtable) {
		hashtable.put(this.key, this.value);
	}
}