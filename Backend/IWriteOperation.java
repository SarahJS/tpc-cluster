import java.util.Hashtable;

public interface IWriteOperation {
	public void Apply(Hashtable<String, String> hashtable);
}