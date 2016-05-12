package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import util.StringUtil;

public class ClientExam {
	public static void main(String[] args) {
		
		Socket socket = null;
		try {
			System.out.println("client start");
			socket = new Socket("127.0.0.1", 8001);
			//Socket socket = new Socket("172.30.51.146", 8113);
			
			//Creates a new data output stream to write data to the specified underlying output stream. The counter written is set to zero.
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); //return an outstream for this socket
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			StringBuffer buf = new StringBuffer();
			for(int i=0; i<10; i++){
				buf.setLength(0);
				buf.append(StringUtil.writeByte("01008840116"+i, 12));				//ctn
				buf.append(StringUtil.writeByte("test message hahahahahaha"+i, 160));	//message
				buf.append(StringUtil.writeByte("O", 1));				//온라인/배치 구분
				buf.append(StringUtil.writeByte("0191112222", 12));		//회신번호
				buf.append(StringUtil.writeByte("appld", 5));			//어플리케이션 구분
				buf.append(StringUtil.writeByte("4098", 4));			//TID
				buf.append(StringUtil.writeByte("reserved", 56));		//reserved

				
				//System.out.println(buf.toString().getBytes());
				System.out.println(i + " 번째 ㄱㄱ====");
				
				//ByteBuffer buffer = ByteBuffer.allocate(buf.toString().getBytes().length*Integer.);
				
				dos.write(buf.toString().getBytes());
				dos.flush();
				
				
				//receive
				int recvLen = 36;
				int off = 0;
				int len = recvLen;
				int total_read_bytes = 0;
				int remain_bytes = recvLen;
				int read_bytes = 0;
				
				byte tmp[] = new byte[recvLen];
				// socket time out 설정
				socket.setSoTimeout(3000);
				do {
					read_bytes = dis.read(tmp, off + total_read_bytes, remain_bytes);

					if (read_bytes <= 0) {
						dis.close();
						break;
					}

					total_read_bytes += read_bytes;
					remain_bytes -= read_bytes;
				} while (total_read_bytes != len);
				
				String response = new String(tmp);
				System.out.println("서버가 보내온 내용 : " + response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( socket != null ) try { socket.close(); } catch (IOException e) {}
		}
	}
}


/*
try {
	System.out.println("client start");
	Socket socket = new Socket("127.0.0.1", 8000);

	// 서버에게 보내기 위한 준비
	BufferedWriter bufferedWriter = new BufferedWriter(
			new OutputStreamWriter(socket.getOutputStream()));

	bufferedWriter.write("안녕하세요!");
	bufferedWriter.newLine(); // readLine()으로 읽기 때문에 개행 추가
	bufferedWriter.flush();

	BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(socket.getInputStream()));
	// 서버부터 메시지 입력받음
	String clientMessage = bufferedReader.readLine();

	// 입력받은 내용을 서버 콘솔에 출력
	System.out.println("서버가 보내온 내용 : " + clientMessage);

	socket.close();// 접속 종료

} catch (Exception e) {
	e.printStackTrace();
}*/