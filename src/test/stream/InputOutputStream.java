package test.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import util.StringUtil;

public class InputOutputStream {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//byte b=35;
		//System.out.print("=======");
		//System.out.write(98);
		//System.out.write('\t');
		//System.out.flush();
		
		/*
		System.out.println(5 & 0x80);
		
		System.out.println(4 & 5);*/
	
		
		//System.out.print('a');
        byte[] by = "°¡¶öAjava learning".getBytes();
        int[] in ={1,2,3};
        
        byte[] hangle = new byte[2];
        hangle[0]=by[0];
        hangle[1]=by[1];
        
        System.out.println(hangle[0]); 
        System.out.println(hangle[1]);
        System.out.println(new String(hangle));
        System.out.println(StringUtil.getString(by));
        //System.out.println(by[4]);
        
       /* System.out.write(by[4]);
        System.out.println(by[4]);
        System.out.flush();
        
        System.out.println(by.length);
        
        System.out.println(StringUtil.getString(by));
        
        
        FileOutputStream f = new FileOutputStream("a.txt");
		for(int i=0; i<1000000; i++){
			f.write(by);
			f.write('B');	
			System.out.println("222");
		}
        
		f.close();*/
		
        //System.out.write(by, 0, 7);   
        
        //byte[] by1 = new byte[]{'J', 'A', 'V', 'A'};   
        //System.out.println(by1);        
      
        
        //PrintStream ps = new PrintStream(System.out, false);
        //System.out.write(by1, 0, by1.length);
        //System.out.write(67);
       
        //ps.write(by, 0, by.length);
        
        
        
        
	        
	        
		
		
		//outputStream();
		//inputStream();
	}
	
	
	static void outputStream(){
		System.out.println("start outputStream"); 
		for(byte i=32; i<127; i++){
			System.out.write(i);
			System.out.write('\t');
		}
	}
	
	
	static void inputStream() throws IOException{
		byte[] buf = new byte[5];
		int a;
		while((a=System.in.read(buf)) >=0)
			System.out.write(buf, 0, a);
	}

}
 