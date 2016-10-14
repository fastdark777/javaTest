package test.string;

import java.io.UnsupportedEncodingException;

public class CharacterSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			charsetSet();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void charsetSet() throws UnsupportedEncodingException{
		//String d = "�ȳ� ��9"; // �ڹٴ� ���� ���ڿ��� ��� �����ڵ� ó���Ѵ�
		String d = "��"; // �ڹٴ� ���� ���ڿ��� ��� �����ڵ� ó���Ѵ�
		  
		// �����ڵ� ���ڿ��� UTF-8 ĳ���� ����Ʈ�迭�� ��ȯ�Ͽ� ��ȯ
		byte [] utf8 = d.getBytes("UTF-8");

		// �����ڵ� ���ڿ��� EUC-KR ĳ���� ����Ʈ�迭�� ��ȯ�Ͽ� ��ȯ
		byte [] euckr = d.getBytes("EUC-KR");
		
		
		byte [] def=d.getBytes();
		
		//utf8 ����Ʈ
		for(byte data : utf8){
			System.out.print(data + " ");
			System.out.println(data & 0xff);
			byte b= (byte) (data & 0xff);
			System.out.println(b + " ");
		}
		
		System.out.println("====");
		
		//euc-kr ����Ʈ
		for(byte data : euckr){
			System.out.println(data & 0xff);
		}
		
		
		  
		// �翬�� �ٸ� ����Ʈ �迭�̹Ƿ� ����� �ٸ���.
		System.out.println("byte length > " + utf8.length); // byte length > 11
		System.out.println("byte length > " + euckr.length); // byte length > 8
		  
		// �Ǽ� �ڵ�.
		// UTF-8 ĳ���ͼ����� �迭�� ����Ʈ�迭�� EUC-KR�� �ؼ��� �� ����.
		System.out.println(new String(utf8, "EUC-KR"));
	}

}
