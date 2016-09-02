package test.etc;

import java.util.logging.Logger;

public class Random {
	
	int a=0;
	
	
	public static void main(String[] args) {
		
		for(int i=0; i<2; i++){
			//System.out.println((int)(Math.random() * 5)); 
			System.out.println(getRandomNumberInRange(0, 2));
		}
		
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return (int)(Math.random() * ((max - min) + 1)) + min;
	}

}
