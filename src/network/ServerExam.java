package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8000); // �������� ����

			while (true) {
				System.out.println("Ŭ���̾�Ʈ ���� ��� ��..."); 
				Socket socket = serverSocket.accept(); // �����������κ��� ���� ��ü ��������

				System.out.println(socket.getInetAddress() + "�� ���ӵǾ����ϴ�.");

				DataOutputStream doss = new DataOutputStream(socket.getOutputStream());
				DataInputStream diss = new DataInputStream(socket.getInputStream());


				//receive
				byte tmp[] = new byte[50];
				diss.read(tmp);
				String response = new String(tmp,"UTF-8");
				
				System.out.println("the contents from the client: " + response);
				

				
				StringBuffer buf = new StringBuffer();
				
				/*buf.append("�ѱ�");
				doss.write(buf.toString().getBytes());
				doss.flush();
*/

				
				socket.close();// ���� ����
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*

System.out.println("Ŭ���̾�Ʈ ���� ��� ��...");
Socket socket = serverSocket.accept(); // �����������κ��� ���� ��ü ��������

System.out.println(socket.getInetAddress() + "�� ���ӵǾ����ϴ�.");

// InputStream inputStream = socket.getInputStream();
// InputStreamReader inputStreamReader = new
// InputStreamReader(inputStream);
// BufferedReader bufferedReader = new
// BufferedReader(inputStreamReader);

// ���� ������ ���ٷ� ǥ��
BufferedReader bufferedReader = new BufferedReader(
		new InputStreamReader(socket.getInputStream()));

// Ŭ���̾�Ʈ�κ��� �޽��� �Է¹���
String clientMessage = bufferedReader.readLine();

// �Է¹��� ������ ���� �ֿܼ� ���
System.out.println("Ŭ���̾�Ʈ�� ������ ���� : " + clientMessage);

// Ŭ���̾�Ʈ���� ������ ���� �غ�
BufferedWriter bufferedWriter = new BufferedWriter(
		new OutputStreamWriter(socket.getOutputStream()));
bufferedWriter.write("JAVA�� ���迡 ���� ���� ȯ���մϴ�!");
bufferedWriter.newLine(); // readLine()���� �����Ƿ� ���ٳ��� �˸�
bufferedWriter.flush();*/