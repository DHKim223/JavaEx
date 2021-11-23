package j17;

// Server - Response

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private ServerSocket ss;	// It's not shared, to check if the server response
	private Socket socket;	// Shared Socket with the client
	private BufferedReader br;
	private BufferedWriter bw;
	private String msg;
	
	public EchoServer(int port) {
		//2. Create Server Socket 
		try {
			ss = new ServerSocket(port);
			while(true) {		// check if the client request
				System.out.println("Wating for requests from Clients... ");
				
				//3.  Waiting for the client's request
				socket = ss.accept(); // **** important ****
				System.out.println("Client : " + socket.getInetAddress().getHostName());
				// 127.0.0.1 == local host
				
				//4. IO Stream
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				while(true) {
					// 6. Recieve Data from the Client
					msg = br.readLine();
					
					// 7. Send Data to the Client
					bw.write(msg);
					bw.newLine();
					bw.flush();
					
					if(msg.equals("exit")) {
						System.out.println("Terminated Connection to the Client");
						break;
					} else {
						System.out.println("Recieved MSG : "+ msg);
					}
				} // while
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( socket != null) socket.close();
				if( br != null) br.close();
				if( bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// Constructor
	
	public static void main(String[] args) {
		new EchoServer(3000);
	}
}
