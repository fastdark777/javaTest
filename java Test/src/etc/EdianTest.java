package etc;

public class EdianTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		StringBuffer buf = new StringBuffer();

		buf.append("ABC");

		int a=getBigEndian(buf.toString().getBytes());
	
		System.out.println(a);
	}
	
	public static byte[] getLittleEndian(int v){
	       byte[] buf = new byte[4];
	       buf[3] = (byte)((v >>> 24) & 0xFF);
	       buf[2] = (byte)((v >>> 16) & 0xFF);
	       buf[1] = (byte)((v >>>  8) & 0xFF);
	       buf[0] = (byte)((v >>>  0) & 0xFF);
	       return buf;
	  }
	 
	
	 /**
	   * Little-Endian ����Ʈ �迭�� �ڹٿ��� ����ϴ� Big-Endian������ ��ȯ�Ѵ�.
	   */
	  public static int getBigEndian(byte[] v)throws Exception{
	       int[] arr = new int[4];
	       for(int i=0;i<4;i++){
	            arr[i] = (int)(v[3-i] & 0xFF);
	       }
	       return ((arr[0]  << 24) + (arr[1]  << 16) + (arr[2]  << 8) + (arr[3]  << 0));
	   }

}
