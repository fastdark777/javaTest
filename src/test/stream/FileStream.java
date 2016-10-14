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
		 
		// ����
		FileOutputStream fos = new FileOutputStream("c:\\iotest\\stream.txt", false);
		// true : Append, �̾��
		// false : Create, ���� ���뿡 �����
		// �⺻�� : false
		 
		fos.write(97); // a�� stream.txt�� ������
		fos.write(98); // b�� stream.txt�� ������
		fos.write(99); // c�� stream.txt�� ������
		
		
		String testString="\nthis is byte test";
		String testString1="\n�̰��� �ѱ�";
		byte[] b = testString.getBytes();
		fos.write(b);
		fos.write(testString1.getBytes());
		fos.close();
				
		// �б�
		FileInputStream fis = new FileInputStream("c:\\iotest\\stream.txt");
		
		int data = 0; 
		while ((data = fis.read()) != -1) { // �� �̻� �������� ���� �� -1
		    System.out.print((char) data); //��Ʈ���� ���� ����Ʈ�ڵ带 ���ڷ� ��ȯ�Ͽ� ���
		    //System.out.println(data); //��Ʈ���� ���� ����Ʈ �ڵ� ���
	
		}
		fis.close();
		
	}
	
	
	public static void dataInputOuptStream() throws IOException{
		File file = new File("c:\\iotest\\sample.dat");
		 
		// ����
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
		 
		// �б�
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
