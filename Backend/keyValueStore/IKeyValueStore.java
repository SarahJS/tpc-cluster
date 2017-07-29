package keyValueStore;
public interface IKeyValueStore {
	public String Get(String key);
	public void Set(String key, String value);
	public void Remove(String key);
}