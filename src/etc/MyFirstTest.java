package etc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MyFirstTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();

		buf.append("ABC");

		
		buf.reverse();
		byte[] b = buf.toString().getBytes();
		System.out.println(b);
		
		//intToByteArray(buf.toString().getBytes());
		
		int aa=byteArrayToInt(b);

		byte[] c = convertBigEndianToLittleEndianByteArray('A');
		System.out.println(c);


	}

	public static byte[] convertBigEndianToLittleEndianByteArray(int i) {
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.order(ByteOrder.LITTLE_ENDIAN).putInt(i);
		byte[] b = buffer.array();
		System.out.print("Little endian buffer of " + i + " = ");
		for (int x = 0; x < b.length; x++)
			System.out.print(b[x] + " ");
		System.out.println();
		return b;
	}
	
	
	private  static byte[] intToByteArray(final int integer) {
		ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE / 8);
		buff.putInt(integer);
		buff.order(ByteOrder.BIG_ENDIAN);
		//buff.order(ByteOrder.LITTLE_ENDIAN);
		return buff.array();
	}
	
	private static  int byteArrayToInt(byte[] bytes) {
		final int size = Integer.SIZE / 8;
		ByteBuffer buff = ByteBuffer.allocate(size);
		final byte[] newBytes = new byte[size];
		for (int i = 0; i < size; i++) {
			if (i + bytes.length < size) {
				newBytes[i] = (byte) 0x00;
			} else {
				newBytes[i] = bytes[i + bytes.length - size];
			}
		}
		buff = ByteBuffer.wrap(newBytes);
		buff.order(ByteOrder.BIG_ENDIAN); // Endian에 맞게 세팅
		return buff.getInt();
	}

}
