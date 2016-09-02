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
            String serverIP = "127.0.0.1"; // 127.0.0.1 & localhost 본인
            System.out.println("서버에 연결중입니다. 서버 IP : " + serverIP);
             
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIP, 5000);
             
            // 소켓의 입력스트림을 얻는다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);  // 기본형 단위로 처리하는 보조스트림
            
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("this is message from client");
            
           
            // 소켓으로 부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
            
            
            /*byte tmp[] = new byte[50];
            dis.read(tmp);            
            String str=new String(tmp, "UTF-8");
            System.out.println("서버로부터 받은 메세지 : " + str);
            */
            
            System.out.println("연결을 종료합니다.");
             
            // 스트림과 소켓을 닫는다.
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
