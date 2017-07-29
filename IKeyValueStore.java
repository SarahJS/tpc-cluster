public interface IKeyValueStore {
	public Get(String key);
	
	public Set(String key, String value);
	
	public Remove(String key);
}