package test.stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriter {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		fileReadWriter();

	}
	
	public static void fileReadWriter() throws IOException{
		// 쓰기
		FileWriter out = new FileWriter("c:\\iotest\\sample.txt", false); 
		//true: Append, 이어쓰기
		//false: Create, 기존 내용에 덮어쓰기
		//기본값 : false
		 
		//String txt = "You just activated \r\nMY TRAP CARD \r\n붑밥붑밥붑밥바";
		//String txt = new String("가".getBytes("UTF-8"),"UTF-8");
		String txt="퀀";
		byte[] txt1="퀀".getBytes("utf-8");
		String txt2 = new String(txt1, "utf8");
		
		out.write(txt2);
		
		out.close();
		
		// 읽기
		FileReader in = new FileReader("c:\\iotest\\sample.txt");
		int data = 0;
		while((data = in.read()) != -1) { // 파일 내용의 길이만큼 루프 
			System.out.print((char) data); // 읽어온 데이터를 문자로 변환 - 출력
		    System.out.println(data); // 읽어온 데이터를 문자로 변환 - 출력
		}
		in.close();

	}

}
