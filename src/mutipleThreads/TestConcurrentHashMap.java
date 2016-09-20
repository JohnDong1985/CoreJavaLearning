package mutipleThreads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

	private static Map<String, String> hm = new HashMap<String, String>();
	private static Map<String, String> chm = new ConcurrentHashMap<String, String>();
	public static void main(String[] args) {
		hm.put(null, "null");
		System.out.println(hm.get(null));
		
		//null point exception
		chm.put(null, "null");
		System.out.println(chm.get(null));
	}
}
