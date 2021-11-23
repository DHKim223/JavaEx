package j17;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;

// Client - Request

public class EchoClient {
	// Virtual device?
	// Client & Server share socket and IO to socket
	private Socket socket;  
	
	private BufferedReader br, brmsg;
	private BufferedWriter bw;
	private String msg, remsg;
	
	public EchoClient (String IP, int port) {
		try {
			// 1. Create Socket
			socket = new Socket(IP, port);
			
			// 4. IO Stream 
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				// 5. Send Data
				brmsg = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Sending MSG : "  );
				msg = brmsg.readLine();
				bw.write(msg);
				bw.newLine();
				bw.flush();
				
				// 8. Recieve Data
				remsg = br.readLine();
				if(remsg.equals("exit")) {
					System.out.println("Terminated Connection to the Server");
					break;
				} else {				
					System.out.println("Recieved MSG : " + remsg);
				}
			}	// while
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( socket != null) socket.close();
				if( br != null) br.close();
				if( bw != null) bw.close();
				if(brmsg != null) brmsg.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// Constructor
	
	public static void main(String[] args) {
		new EchoClient("localhost", 3000); // Server IP & Port number 	// localhost = myself
	}
}
