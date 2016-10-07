package util;

import java.text.DecimalFormat;

public  class StringUtil {
	
	public static void main(String[] args) {
		
		String aa="[국제전화002]   제성종합물류(주)님 1분48초 002통화요금     1,320원 -당월누적요금 8,880원";
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
	 * 2016. 6. 16. 오후 1:50:19
	 */
	public static String getString(byte[] input) {
		// StringBuffer객체를 선언하여 String을 이어 붙입니다.
		StringBuffer rtn = new StringBuffer();

		// byte[ ]의 길이만큼 반복해서 byte 하나 하나씩 처리합니다.
		for (int i = 0; i < input.length;) {
			// 한글처리부분
			// ( input[ i ] & 0x80 ) == 0x80 이조건을 만족하면 input[i]는
			// 음수 즉, 한글의 두개의 byte중 첫번째 byte라는 뜻이므로
			// input[++i]와 함께 String으로 만들어서 한글 한글자를 생성합니다.
			if ((input[i] & 0x80) == 0x80) {
				byte[] hangle = new byte[2];
				hangle[0] = input[i];
				hangle[1] = input[++i];
				rtn.append(new String(hangle));
			}

			// 한글이외 처리부분 ( 영어, 숫자, 특문등등 )
			else{
				rtn.append((char) input[i]);
			}

			// 다음번 byte를 읽기 위해 input의 index증가시키는 부분
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
