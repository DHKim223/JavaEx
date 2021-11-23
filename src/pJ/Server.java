package pJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	// 서버쪽으로 클라이언트가 접속했을때 쓰레드 저장하는 어레이리스트
	private ArrayList<MultiServerThread> list;	
	
	private Socket socket;
	private ServerSocket ss;
	
	// 생성자 호출
	public Server() {	
		// MultiServerThread 라는 쓰레드를 저장하는 어레이 리스트.
		list = new ArrayList<MultiServerThread>();		
		try {
			
			ss = new ServerSocket(5000);
			MultiServerThread mst = null;
			boolean isStop = true;
			System.out.println("서버 정상 실행중");
	
			while(isStop) {
				socket = ss.accept();	// 서버가 클라이언트에 접속 요청
				mst = new MultiServerThread();	// 서버통신 담당하는 쓰레드 실행
				list.add(mst);	// 리스트에 쓰레드 더함
				mst.start();	// 쓰레드를 스타트
			} 			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 클라이언트와 통신하는 쓰레드
	public class MultiServerThread extends Thread{
		
		InputStream is;
		BufferedReader br;
		BufferedWriter bw;
		PrintWriter pw;
		OutputStream os;
		String message;
		
		public void run() {
			System.out.println("MultiServer is called");
			boolean isStop = false;
			try {
				// 클라이언트로 부터 Input을 받음
				is = socket.getInputStream();
				// 그 Input을 다른 클라이언트에 발신
				os = socket.getOutputStream();
				
				br = new BufferedReader(new InputStreamReader(is));
				bw = new BufferedWriter(new OutputStreamWriter(os));
				pw = new PrintWriter(bw,true);
				while(!isStop) {
					message = br.readLine();
					String[] str = message.split("#");
					if(str[1].equals("exit")) {
						broadCasting(message);
						isStop = true;
					} else {
						broadCasting(message);
					} // else
					
				} // while
				
				// arryalist 에 저장된 클라이언트 쓰레드 객체 제거
				list.remove(this);
				System.out.println(socket.getInetAddress() + "IP주소의 사용자 종료");
				System.out.println("남은 사용자수: " + list.size() );
			} catch (IOException e) {
				e.printStackTrace();
				list.remove(this);
				System.out.println(socket.getInetAddress() + "IP주소의 사용자의"
						+ "비정상 종료");
				System.out.println("남은 사용자수: " + list.size() );
			}
		}
		
		public void broadCasting(String message) {
			System.out.println("broadcasting is called");
			for (MultiServerThread ct : list) {
				ct.send(message);
			}
		}
		
		public void send (String message) {
			pw.println(message);
		}
		
	}
				

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}

}
