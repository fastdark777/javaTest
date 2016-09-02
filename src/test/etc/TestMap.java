package test.etc;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("aaaa", "aaaa");
		m.put("timestmp1", "tttt");
		
		if(m.get("timestmp")!=null){
			System.out.println("aassdasdsfsdf");
		}else{
			System.out.println("else");
		}
		
		System.out.println(m.get("timestmp"));
		
			
		
		
	}
}
