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
		// ����
		FileWriter out = new FileWriter("c:\\iotest\\sample.txt", false); 
		//true: Append, �̾��
		//false: Create, ���� ���뿡 �����
		//�⺻�� : false
		 
		//String txt = "You just activated \r\nMY TRAP CARD \r\n�ֹ�ֹ�ֹ��";
		//String txt = new String("��".getBytes("UTF-8"),"UTF-8");
		String txt="��";
		byte[] txt1="��".getBytes("utf-8");
		String txt2 = new String(txt1, "utf8");
		
		out.write(txt2);
		
		out.close();
		
		// �б�
		FileReader in = new FileReader("c:\\iotest\\sample.txt");
		int data = 0;
		while((data = in.read()) != -1) { // ���� ������ ���̸�ŭ ���� 
			System.out.print((char) data); // �о�� �����͸� ���ڷ� ��ȯ - ���
		    System.out.println(data); // �о�� �����͸� ���ڷ� ��ȯ - ���
		}
		in.close();

	}

}
