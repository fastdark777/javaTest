package test.math;

import java.math.BigInteger;

import util.StringUtil;

public class Factorial {
	public static void main(String[] args) {
		//System.out.format("%d%n",factorial(12345));		
		System.out.println(factorial(1676));
		String aaa="";
		
//		 for (int i = 0; i <= 12345; i++)
//		      System.out.format("%3d! = %d%n", i, factorial(i));
	}
	
	  public static BigInteger factorial(int n) {
	    BigInteger fac = BigInteger.ONE;

	    for (int i = 1; i <= n; i++){
	      fac = fac.multiply(BigInteger.valueOf(i));
	    }

	    return fac;
	  }
	  
	  public static long factorial1(int n) {
		    int fac = 1;
		    
		    for(int i=1; i<=n; i++){
		    	fac=fac*i;
		    }

		  
		    return fac;
	}
}
