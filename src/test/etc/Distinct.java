package test.etc;

public class Distinct {

	public static void main(String[] args) {

		String tmp="zaazabbzbczczc";
		
		System.out.println(getCnt(tmp, distinct(tmp)));

	}
	
	public static String distinct(String str){
		String tmp="";		
		StringBuffer sb= new StringBuffer();
		
		for(int i=0; i<str.length(); i++){
			int cnt=0;
			
			for(int j=0; j<sb.length(); j++){
				if(str.charAt(i)==sb.charAt(j)){
					cnt++;
				}
			}
			
			if(cnt==0){
				sb.append(str.charAt(i));
				cnt=0;
			}
		}

		return sb.toString(); 
	}
	
	
	public static String getCnt(String ori, String tar){	
		StringBuffer sb = new StringBuffer();
		char tchar=0;
		
		for(int i=0; i<tar.length(); i++){
			int cnt=0;
			for(int j=0; j<ori.length(); j++){
				if(ori.charAt(j)==tar.charAt(i)){
					cnt++;
					tchar=tar.charAt(i);
				}
			}
			sb.append(tar.charAt(i));
			sb.append(cnt);
		}

		return sb.toString();
	}
}
