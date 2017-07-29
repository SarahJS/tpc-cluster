
public class Server {
	public static void main(String[] args) {
		IKeyValueStore kvs = new TwoPhaseCommitKeyValueStore();
		System.out.println("I LIVE");
	}
}
