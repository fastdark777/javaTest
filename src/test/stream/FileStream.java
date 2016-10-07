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
		 
		// ����
		FileOutputStream fos = new FileOutputStream("c:\\iotest\\stream.txt", false);
		// true : Append, �̾��
		// false : Create, ���� ���뿡 �����
		// �⺻�� : false
		 
		fos.write(97); // a�� stream.txt�� ������
		fos.write(98); // b�� stream.txt�� ������
		fos.write(99); // c�� stream.txt�� ������
		
		
		String testString="\n this is byte test";
		String testString1="\n �̰��� �ѱ�";
		byte[] b = testString.getBytes();
		//fos.write(b);
		fos.write(testString1.getBytes());
		fos.close();
		
		
		// �б�
		FileInputStream fis = new FileInputStream("c:\\iotest\\stream.txt");
		
		byte[] bb = new byte[16];
		
		DataInputStream dis = new DataInputStream(fis);
		//dis.read(bb,0,16);
		
		
		System.out.println(StringUtil.getString(dis.rea));
		//System.out.println(StringUtil.getString(bb));
		
		int data = 0; 
		while ((data = fis.read()) != -1) { // �� �̻� �������� ���� �� -1
		    //System.out.print((char) data); //��Ʈ���� ���� ����Ʈ�ڵ带 ���ڷ� ��ȯ�Ͽ� ���
		//    System.out.println(data); //��Ʈ���� ���� ����Ʈ�ڵ带 ���ڷ� ��ȯ�Ͽ� ���
		}
		fis.close();
	}

}
