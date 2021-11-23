package pJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClientSV implements Runnable, ActionListener {
	
	private static final String SERVER_IP = "Server IP Address";
	private Socket socket;
	private String ip;
	private String chatName;
	
	/////
	private JFrame jframe;
	
	InputStream is;
	OutputStream os;
	BufferedReader br;
	BufferedWriter bw;
	PrintWriter pw = null;
	
	public ClientSV () {
		chatName = JOptionPane.showInputDialog(jframe,"ID 를 입력하세요","ID 입력창", JOptionPane.YES_NO_OPTION);
		if(chatName.length() == 0 || chatName == null) {
			System.exit(0);
		}
	}
	
	public void init() {
		try {
			socket = new Socket (ip, 5000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw,true);
			Thread t = new Thread(this); // 서버와 연동할 쓰레드 객체
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		
	}
}
