package j18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// MultiCasting => BroadCasting - Write Output to All Clients

class MultiServerThread extends Thread{
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private String name;
	private String msg;
	
	static ArrayList<BufferedWriter> list = new ArrayList < BufferedWriter>();	// write all bufferedwriter from clients
	public MultiServerThread(Socket socket) throws IOException{
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		list.add(bw); 	// To add to the list, declare br, bw in the constructor
	}
	
	public void run() {
		try {
			name = br.readLine();	// Ã¤ÆÃ¸í
			sendMsg("<<" + name + ">>  has entered"  );
			
			while(true) {
				msg = br.readLine();
				
				if ( msg.equals("exit")) {
					bw.write(msg);
					bw.newLine();
					bw.flush();
								
					sendMsg( "<<" + name + ">> has quit" );				
					break;
				} else {				
				}
				sendMsg("[" + name + "] : " + msg);
			} 
			 
		} catch(IOException e) {
			e.printStackTrace();		// Force to turn off
			try {
				sendMsg( "<<" + name + ">> has quit.");
			} catch ( IOException ex) {
				ex.printStackTrace();
			}
		}	finally {
			list.remove(bw);
			try {
				if(socket != null) socket.close();
				if(br != null) br.close();
				if(bw != null) bw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg( String msg) throws IOException {
		for (BufferedWriter bw : list) {
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
	}
	
}

public class MultiServer {
	// Constructor
	private ServerSocket ss;
	private Socket socket;
	public MultiServer(int port) {
		try {
			ss= new ServerSocket(port);
			while(true) {
				System.out.println("Wating for the Request....");
				socket = ss.accept();
				MultiServerThread mst = new MultiServerThread(socket);
				mst.start();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}// Constructor
	
	
	
	public static void main(String[] args) {
		new MultiServer(3000);
	}
}
