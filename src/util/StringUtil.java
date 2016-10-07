package util;

import java.text.DecimalFormat;

public  class StringUtil {
	
	public static void main(String[] args) {
		
		String aa="[������ȭ002]   �������չ���(��)�� 1��48�� 002��ȭ���     1,320�� -���������� 8,880��";
		String bb="aa";
		System.out.println(new String(aa.getBytes()));
		
		byte[] baa=bb.getBytes();
		
		//System.out.println(getCommaa("12312312"));
	}

	public static String writeByte(String str, int len){
		StringBuffer buffer = new StringBuffer(len);
		
		if(str.length() < len){
			buffer.append(str);
			
			int iSize = buffer.toString().getBytes().length;
			
			for(int i=0; i< len - iSize; i++){
				buffer.append(" ");
			}
		}else{
			buffer.append(str);
		}
		
		return buffer.toString();
	}
	

	
	
	/**
	 * byte[] to String
	 * @param input
	 * @return
	 * 2016. 6. 16. ���� 1:50:19
	 */
	public static String getString(byte[] input) {
		// StringBuffer��ü�� �����Ͽ� String�� �̾� ���Դϴ�.
		StringBuffer rtn = new StringBuffer();

		// byte[ ]�� ���̸�ŭ �ݺ��ؼ� byte �ϳ� �ϳ��� ó���մϴ�.
		for (int i = 0; i < input.length;) {
			// �ѱ�ó���κ�
			// ( input[ i ] & 0x80 ) == 0x80 �������� �����ϸ� input[i]��
			// ���� ��, �ѱ��� �ΰ��� byte�� ù��° byte��� ���̹Ƿ�
			// input[++i]�� �Բ� String���� ���� �ѱ� �ѱ��ڸ� �����մϴ�.
			if ((input[i] & 0x80) == 0x80) {
				byte[] hangle = new byte[2];
				hangle[0] = input[i];
				hangle[1] = input[++i];
				rtn.append(new String(hangle));
			}

			// �ѱ��̿� ó���κ� ( ����, ����, Ư����� )
			else{
				rtn.append((char) input[i]);
			}

			// ������ byte�� �б� ���� input�� index������Ű�� �κ�
			++i;
		}
		return rtn.toString();
	}
	
	
	public static String getComma(long num){
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(num);
	}
	
	
	public static String getComma(double num){
	
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(num);
		
	}
	
	  
	public static <E extends Comparable<E>> E getCommaa(E num){
	
		DecimalFormat df = new DecimalFormat("#,##0");
		return (E) df.format(num);
		
	}
	

}
