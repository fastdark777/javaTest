package test.logic;

public class LogicShift {

	/**
	 * 
	 * @param args
	 *            2016. 7. 28. ���� 10:07:32
	 */
	public static void main(String[] args) {
		byte a = 10; // 00001010
		byte b = 9; // 00001001
		byte c = 1; // ����Ʈ�� ĭ��
		System.out.println(a + " & " + b + " = " + (a & b)); // ����
		System.out.println(a + " | " + b + " = " + (a | b)); // ����
		System.out.println(a + " ^ " + b + " = " + (a ^ b)); // ��Ÿ�� ����(xor)
		System.out.println("~10 = " + (~a)); // a �� ����(����)
		System.out.println(a + " << " + c + " = " + (a << c)); // ���� 1��Ʈ ����Ʈ(�ڸ�
																// 0 ���� ä��)
		System.out.println(a + " >> " + c + " = " + (a >> c)); // ������ 1��Ʈ ����Ʈ(����
																// �и����� ù°�ڸ���
																// ������ ��Ʈ�� ä��)
		System.out.println(a + " >>> " + c + " = " + (a >>> c)); // ������ 1��Ʈ ��
																	// ����Ʈ(���� 0
																	// ���� ä��)
		System.out.println(-1 * a + " >> " + c + " = " + (-1 * a >> c));

	}

}
