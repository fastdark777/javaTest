package util;

public class StringUtil {

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

}
