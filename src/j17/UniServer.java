package j17;

// UniCasting				 Connect multiple clients to the Server
// Server - Response
// Thread is required to run multiple sockets ( clients)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class UniServerThread extends Thread {
	private BufferedReader br;
	private BufferedWriter bw;
	private String msg;
	private Socket socket;	
	
	public UniServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			System.out.println( "Client : " + socket.getInetAddress().getHostName()  );
			br = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );	
			bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );
			while( true ) {
				msg = br.readLine();
				bw.write( msg );
				bw.newLine();
				bw.flush();			
				
				if( msg.equals( "exit" ) ) {
					System.out.println( "Disconnect client" );
					break;
				} else {
					System.out.println( "MSG Recieved : " + msg );
				}
			} // while			
		} catch( IOException e ) {
			e.printStackTrace();
		} finally {
			try {
				if( socket != null ) socket.close();
				if( br != null ) br.close();
				if( bw != null ) bw.close();				
			} catch( IOException e ) {
				e.printStackTrace();
			}
		}				
	} // run()	
}

public class UniServer {	
	private ServerSocket ss;
	private Socket socket;

	public UniServer( int port ) {
		try {
			ss = new ServerSocket( port );
			while( true ) {
				System.out.println( "Wating for the request" );
				socket = ss.accept();
				
				UniServerThread ust = new UniServerThread(socket);
				ust.start();
				
			} // while	 		
		} catch( IOException e ) {
			e.printStackTrace();
		} 
	} // »ý¼ºÀÚ	
	public static void main(String[] args) {
		new UniServer( 3000 );
	}
}