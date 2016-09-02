package test.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
 

public class ClientTest {

	public static void main(String[] args) {
        try {
            String serverIP = "127.0.0.1"; // 127.0.0.1 & localhost ����
            System.out.println("������ �������Դϴ�. ���� IP : " + serverIP);
             
            // ������ �����Ͽ� ������ ��û�Ѵ�.
            Socket socket = new Socket(serverIP, 5000);
             
            // ������ �Է½�Ʈ���� ��´�.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);  // �⺻�� ������ ó���ϴ� ������Ʈ��
            
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("this is message from client");
            
           
            // �������� ���� ���� �����͸� ����Ѵ�.
            System.out.println("�����κ��� ���� �޼��� : " + dis.readUTF());
            
            
            /*byte tmp[] = new byte[50];
            dis.read(tmp);            
            String str=new String(tmp, "UTF-8");
            System.out.println("�����κ��� ���� �޼��� : " + str);
            */
            
            System.out.println("������ �����մϴ�.");
             
            // ��Ʈ���� ������ �ݴ´�.
            dis.close();
            socket.close();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } // try - catch
    } // main

}
