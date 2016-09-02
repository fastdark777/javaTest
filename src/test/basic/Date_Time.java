package test.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Time {

	/**
	 * 
	 * @param args
	 * 2016. 7. 18. ¿ÀÈÄ 8:25:12
	 */
	public static void main(String[] args) {
		  try {
		         long start = System.currentTimeMillis( );
		         System.out.println(new Date( ) + "\n");
		         Thread.sleep(3000);
		         System.out.println(new Date( ) + "\n");
		         long end = System.currentTimeMillis( );
		         long diff = end - start;
		         System.out.println("Difference is : " + diff);
		      } catch (Exception e) {
		         System.out.println("Got an exception!");
		      }
	}

}
