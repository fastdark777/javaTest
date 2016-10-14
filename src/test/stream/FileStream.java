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
		
		try {
			//fileOutputStream();
			
			dataInputOuptStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void fileOutputStream() throws IOException{
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
		
		
		String testString="\nthis is byte test";
		String testString1="\n이것은 한글";
		byte[] b = testString.getBytes();
		fos.write(b);
		fos.write(testString1.getBytes());
		fos.close();
				
		// 읽기
		FileInputStream fis = new FileInputStream("c:\\iotest\\stream.txt");
		
		int data = 0; 
		while ((data = fis.read()) != -1) { // 더 이상 읽을것이 없을 때 -1
		    System.out.print((char) data); //스트림이 읽은 바이트코드를 문자로 변환하여 출력
		    //System.out.println(data); //스트림이 읽은 바이트 코드 출력
	
		}
		fis.close();
		
	}
	
	
	public static void dataInputOuptStream() throws IOException{
		File file = new File("c:\\iotest\\sample.dat");
		 
		// 쓰기
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeBoolean(true);
		dos.write(5);
		dos.writeByte((byte) 5);
		dos.writeInt(100);
		dos.writeDouble(200.5);
		dos.writeUTF("utfutfutf");
		dos.writeBoolean(false);
		//dos.writeBoolean(false);
		 
		dos.flush();
		dos.close();
		 
		// 읽기
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		System.out.println(dis.readBoolean());
		System.out.println(dis.read());
		System.out.println(dis.readByte());
		System.out.println(dis.readInt());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		System.out.println(dis.readBoolean());
		dis.close();

	}

}
