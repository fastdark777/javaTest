package test.socket;

import java.text.SimpleDateFormat;

public class test {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arrSecDelivCnt[]  = new int[60];
		int m_nSecCount = 0;
		java.util.Date today = null;
		SimpleDateFormat secFormat = new SimpleDateFormat("ss");
		
		today		= new java.util.Date();
		int nCurrSec= secFormat.format(today)!=null ? Integer.parseInt(secFormat.format(today)) : 0;
		System.out.println(nCurrSec);
		today		= null;
		for ( int i = 0; i < 60; i++ ) {
			if ( nCurrSec == i )
				//System.out.println("ddd");
				continue;
			else
				arrSecDelivCnt[i] = 1;
		}
		
		for(int i=0; i<arrSecDelivCnt.length; i++){
			System.out.println(i+ "=>" +arrSecDelivCnt[i]);
		}
		
		/*int i=0;
		for(int tmp : arrSecDelivCnt){
			//System.out.println(i++);
			System.out.println(i + "=> " +tmp);
			i++;
		}*/
		
		//System.out.println(i);

	}

}
