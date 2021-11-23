package j18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

// MultiCasting 					Threads - Input / Output simultaneously

class MultiReadThread extends Thread{
	private Socket socket;
	private BufferedReader br;
	private String msg;
	public MultiReadThread(Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	public void run() {
		try {
			while(true) {
				msg = br.readLine();
				if( msg.equals("exit")) {
					System.out.println("Disconnect");
					break;
				} else {
					System.out.println(msg);
				}				
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) socket.close();
				if( br!= null) br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
} // MultiReadThread

class MultiWriteThread extends Thread {
	private Socket socket;
	private String name = " JP ";
	private BufferedWriter bw;
	private String msg;
	private BufferedReader brmsg;
	
	public MultiWriteThread(Socket socket)throws IOException {
		this.socket = socket;
		bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );
		brmsg = new BufferedReader( new InputStreamReader(System.in));
		bw.write(name);
		bw.newLine();
		bw.flush();
	}
	
	public void run() {
		try {
			while(true) {
				msg = brmsg.readLine();
				bw.write(msg);
				bw.newLine();
				bw.flush();
				if(msg.equals("exit")) break;
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
			//	if (socket != null) socket.close();  // Don't close it again, 
				if (bw != null) bw.close();
				if( brmsg != null) brmsg.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}


public class MultiClient {
	private Socket socket;
	public MultiClient(String ip, int port ) {
		try {
			socket = new Socket(ip, port);
			MultiReadThread mrt = new MultiReadThread(socket);
			MultiWriteThread mwt = new MultiWriteThread(socket);
			mrt.start();
			mwt.start();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MultiClient("localhost",3000);	// excludes 0~1023, use any number between 1024 ~ 6535
	}
}
