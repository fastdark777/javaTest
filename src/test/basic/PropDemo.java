package test.basic;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropDemo {

	/**
	 * 
	 * @param args
	 *            2016. 7. 20. ¿ÀÀü 10:35:38
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties capitals = new Properties();
		Set states;
		String str;
		
		String str1="abc";
		String str2="ab";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		

		capitals.put("Illinois", "Springfield");
		capitals.put("Missouri", "Jefferson City");
		capitals.put("Washington", "Olympia");
		capitals.put("California", "Sacramento");
		capitals.put("Indiana", "Indianapolis");

		// Show all states and capitals in hashtable.
		states = capitals.keySet(); // get set-view of keys
		
		System.out.println(states);
		Iterator itr = states.iterator();
		while (itr.hasNext()) {
			str = (String) itr.next();
			System.out.println("The capital of " + str + " is "
					+ capitals.getProperty(str) + ".");
		}
		System.out.println();
	
		// look for state not in list -- specify default
		str = capitals.getProperty("Florida", "Not Found");
		System.out.println("The capital of Florida is " + str + ".");
	}

}
