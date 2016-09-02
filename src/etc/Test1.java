package etc;

import java.io.UnsupportedEncodingException;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("ÇÑ±Û");
		
		try {
			System.out.println(buf.toString().getBytes("utf-8").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
