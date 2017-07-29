package primary;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import keyValueStore.IKeyValueStore;
import keyValueStore.TwoPhaseCommitKeyValueStore;

@Path("/KeyValueStore")
public class RESTInterface { 
	private static IKeyValueStore myKVS = new TwoPhaseCommitKeyValueStore();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public static String Get(String key) {
		return myKVS.Get(key);
	}
	
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public static void Put(String key, String value) {
		myKVS.Set(key, value);
	}
	
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	public static void Delete(String key) {
		myKVS.Remove(key);
	}
	
	public static void main(String[] args) {
		// Pass in IPs of secondaries.
		System.out.println("I LIVE");
	}
	
}
