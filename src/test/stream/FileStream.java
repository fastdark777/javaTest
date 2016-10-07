package test.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import util.StringUtil;

public class FileStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileStream f = new FileStream();
		
		try {
			f.test1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void test1() throws IOException{
		File file = new File("c:\\iotest", "stream.txt");
		
		if (!file.exists()) {
		    file.createNewFile();
		}
		 
		// 쓰기
		FileOutputStream fos = new FileOutputStream("c:\\iotest\\stream.txt", false);
		// true : Append, 이어쓰기
		// false : Create, 기존 내용에 덮어쓰기
		// 기본값 : false
		 
		fos.write(97); // a가 stream.txt에 쓰여짐
		fos.write(98); // b가 stream.txt에 쓰여짐
		fos.write(99); // c가 stream.txt에 쓰여짐
		
		
		String testString="\n this is byte test";
		String testString1="\n 이것은 한글";
		byte[] b = testString.getBytes();
		//fos.write(b);
		fos.write(testString1.getBytes());
		fos.close();
		
		
		// 읽기
		FileInputStream fis = new FileInputStream("c:\\iotest\\stream.txt");
		
		byte[] bb = new byte[16];
		
		DataInputStream dis = new DataInputStream(fis);
		//dis.read(bb,0,16);
		
		
		System.out.println(StringUtil.getString(dis.rea));
		//System.out.println(StringUtil.getString(bb));
		
		int data = 0; 
		while ((data = fis.read()) != -1) { // 더 이상 읽을것이 없을 때 -1
		    //System.out.print((char) data); //스트림이 읽은 바이트코드를 문자로 변환하여 출력
		//    System.out.println(data); //스트림이 읽은 바이트코드를 문자로 변환하여 출력
		}
		fis.close();
	}

}
