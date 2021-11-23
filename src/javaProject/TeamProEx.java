package javaProject;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import java.awt.GridLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


class MultiClientThread extends Thread {
    
	private TeamProEx mc;
    private int i =0;
    private String[] Ruser = null;
    public MultiClientThread( TeamProEx mc ){
        this.mc = mc; 
    }
    
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        String[] waitMsg = null;
        String[] rmsg = null;
        String answer = null;
        boolean isStop = false;
        boolean wait = true;
        boolean popup = false;
        while(!isStop){
            try{
                message = (String)mc.getOis().readObject();
                if(message.contains("#")) {
                	receivedMsg = message.split( "#" );
                	System.out.println(receivedMsg[0] +" : "+receivedMsg[1]);
                	wait = false;
                }else if( message.contains("@")){
                	receivedMsg = message.split( "@" );
                	System.out.println("자른 1번배열"+receivedMsg[1]);
                	answer = receivedMsg[1];
                	System.out.println("answer : "+answer);
               }else if(message.contains("&")) {
            	   waitMsg = message.split( "&" );
            	   System.out.println(waitMsg[0] +" : "+waitMsg[1]);
            	   wait = true;
               }else if(message.contains("※")) {
            	   rmsg = message.split("※");
            	   Ruser[i] = rmsg[0];
            	   System.out.println(rmsg[0] +" : "+rmsg[1]);
            	   wait = true;
               }
                
            }catch(Exception e){
                e.printStackTrace();
                isStop = true; 
            }
//            System.out.println(receivedMsg[0]+","+receivedMsg[1]);
            if(wait == false) {
            	if(receivedMsg[1].equals( "exit" )){
	                if(receivedMsg[0].equals(mc.getId())){
	                    mc.exit();
	                }else{
	                    mc.getJta().append(
	                    receivedMsg[0] +"님이 종료하셨습니다."+
	                    System.getProperty("line.separator"));
	                    mc.getJta().setCaretPosition(
	                    mc.getJta().getDocument().getLength());
	                }
            	}else{               
	                mc.getJta().append(
	                receivedMsg[0] +" : "+receivedMsg[1]+
	                System.getProperty("line.separator"));
	                mc.getJta().setCaretPosition(
	                    mc.getJta().getDocument().getLength());
	            }
            }else if(wait == true){
            	if(waitMsg[1].equals( "exit" )){
	                if(waitMsg[0].equals(mc.getId())){
	                    mc.exit();
	                }else{
	                    mc.getWaitA().append(
	                    		waitMsg[0] +"님이 종료하셨습니다."+
	                    System.getProperty("line.separator"));
	                    mc.getWaitA().setCaretPosition(
	                    mc.getWaitA().getDocument().getLength());
	                }
	            }
	            	 else {
            	mc.getWaitA().append(waitMsg[0] +" : "+waitMsg[1]+
    	                System.getProperty("line.separator")
            			);
            	mc.getWaitA().setCaretPosition(
	                    mc.getWaitA().getDocument().getLength());
	            }
            }
        }
    }
}// 쓰레드 클래스


public class TeamProEx implements ActionListener{

	// 닉네임 프레임
	private JFrame jf3;
	
	//대기실 프레임
	private JFrame jf2;
	private JPanel waitP= new JPanel();
	private JTextArea waitTA = new JTextArea("",10,50);
	private JPanel waitPN = new JPanel();
	private JButton waitR = new JButton("준비");
	private JLabel waitL ;
	private JPanel waitPS = new JPanel();
	private JTextField waitTF = new JTextField();
	private JButton waitB = new JButton("입력");
	
	private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String ip;					//아이피
    private String id;					//닉네임
    
    // 게임 진행 프레임
    private JFrame jf1;
    private JLabel UsLb = new JLabel("UserName");  //다른유저 나타내는 라벨
    private JButton NaBtn = new JButton("\uC900\uBE44");	//준비버튼
    private JLabel NaLb = new JLabel("Myname");		//내 이름 나타내는 라벨
    private JPanel panel = new JPanel(); 						// 채팅입력 필드, 입력 버튼, 종료 버튼 붙이는 패널
    private JButton ChBtn = new JButton("\uC785\uB825");	//입력 버튼.
    private JButton ChEBtn = new JButton("\uC885\uB8CC");				// 종료 버튼
    private JTextArea ChTa = new JTextArea();								//입력한 채팅 나타나는 TextArea
    private JTextField ChTp= new JTextField();	// 채팅부분 텍스트 필드
    private final JLabel TimeL = new JLabel();
    
    private JPanel ChatP ;		//채팅 패널	
	private JPanel ImageP ;	// 이미지 패널
	private JPanel NameP ;		// 자신의 닉네임 패널
	private JPanel UserP ;		// 다른 접속 유저의 패널
    
	
	public TeamProEx(String argIp,String argId) {
		ip = argIp;
        id = argId;
        
        //닉네임 정하는 프레임
        
        //대기실 패널 관련
        
       jf2 = new JFrame("대기실");
       jf2.setLayout(new BorderLayout());
       waitL = new JLabel("닉네임 : "+id, JLabel.RIGHT);
        
       waitTA.setEditable(false);
       waitTA.setVisible(true);
       
       JScrollPane jsp = new JScrollPane( waitTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
               JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
       
       waitTF.addActionListener(this);
       waitB.addActionListener(this);
       
       waitR.addActionListener(this);
       waitPN.add(waitR,BorderLayout.WEST);
       waitPN.add(waitL,BorderLayout.CENTER);
        
       waitPS.setLayout(new BorderLayout());
       waitPS.add(waitTF);
       waitPS.add(waitB,BorderLayout.EAST);
       
       waitP.setLayout(new BorderLayout());
       waitP.add(waitPN,BorderLayout.NORTH);
       waitP.add(jsp,BorderLayout.CENTER);
       waitP.add(waitPS,BorderLayout.SOUTH);
        
        jf2.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e) {
                try {
                    oos.writeObject(id+"#exit");
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                System.exit(0);
            }
            public void windowOpened(WindowEvent e) {
                ChTp.requestFocus();
            }
        });
        
        jf2.add(waitP);
        
        
        jf2.setBounds(600,600,600,600);
		jf2.setVisible(true);
        jf2.setResizable(false);
        
        
        //게임플레이 패널 관련
		jf1 = new JFrame("방탈출");
		jf1.getContentPane().setBackground(Color.BLACK);
		
		 ChatP = new JPanel();		//채팅 패널	
		 ImageP = new JPanel();		// 이미지 패널
		 NameP = new JPanel();		// 자신의 닉네임 패널
		 UserP = new JPanel();		// 다른 접속 유저의 패널
		GroupLayout groupLayout = new GroupLayout(jf1.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(ImageP, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(ChatP, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
								.addComponent(UserP, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(NameP, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(ImageP, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(NameP, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(UserP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ChatP, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)))
					.addContainerGap())
		);
		GroupLayout gl_ImageP = new GroupLayout(ImageP);
		gl_ImageP.setHorizontalGroup(
			gl_ImageP.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_ImageP.createSequentialGroup()
					.addContainerGap()
					.addComponent(TimeL, GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_ImageP.setVerticalGroup(
			gl_ImageP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ImageP.createSequentialGroup()
					.addComponent(TimeL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(910, Short.MAX_VALUE))
		);
		ImageP.setLayout(gl_ImageP);
		
		UserP.add(UsLb);
		NameP.setLayout(new GridLayout(1, 0, 0, 0));
				
		NaBtn.setActionCommand("");
		NameP.add(NaBtn);
			
		NameP.add(NaLb);
		ChatP.setLayout(new BorderLayout(0, 0));
				
		ChatP.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
				
		ChTp.setColumns(30);
		panel.add(ChTp);
		ChTp.addActionListener(this);
		
		ChBtn.addActionListener(this);
		panel.add(ChBtn);
		
		ChEBtn.addActionListener(this);
		panel.add(ChEBtn);
				
		ChTa.setEditable(false);
		
		ChatP.add(ChTa, BorderLayout.CENTER);
		
		

		
		//
		jf1.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e) {
                try {
                    oos.writeObject(id+"#exit");
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                System.exit(0);
            }
            public void windowOpened(WindowEvent e) {
                ChTp.requestFocus();
            }
        });
		
		
		jf1.getContentPane().setLayout(groupLayout);
		jf1.setSize(new Dimension(1300, 1000));
		jf1.setVisible(true);
		jf1.setResizable(false);
		
	}
	 
	//이벤트 처리 부분.
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
        String msg = ChTp.getText();
        String waitmsg = waitTF.getText();
        

        try {
	        if ( obj == ChTp ) {
	            if ( msg == null || msg.length()==0 ) {
	                JOptionPane.showMessageDialog( jf1, "글을쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
	            } else {
	                
	                    oos.writeObject( id + "#" + msg );
	                
	                ChTp.setText("");
	            }
	        } else if ( obj == ChEBtn ) {
	            
	            oos.writeObject( id + "#exit" );
	            
	            System.exit( 0 );
	        }else if(obj == waitB || obj == waitTF){
	        		if ( waitmsg == null || waitmsg.length()==0 ) {
	                    JOptionPane.showMessageDialog( jf2, "글을쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
	                } else {
	                    oos.writeObject( id + "&" + waitmsg );
	                    waitTF.setText("");
	                }
	        }else if(obj == waitR){
	        	oos.writeObject(id+"※준비완료");
	        }//if문
	        
	        
        }catch (IOException ee) {
			ee.printStackTrace();
		}

	}//이벤트 처리기 
	
	public void init() throws IOException {
        socket = new Socket( "localhost" , 3000 );			// ip
        System.out.println( "connected..." );
        oos = new ObjectOutputStream( socket.getOutputStream() );
        ois = new ObjectInputStream( socket.getInputStream() );
        MultiClientThread ct = new MultiClientThread( this );
        Thread t = new Thread( ct );
        t.start();
    }
	
	public ObjectInputStream getOis(){
        return ois;
    }
    public JTextArea getJta(){
        return ChTa;
    }
    public String getId(){
        return id;
    }
    public void exit(){
        System.exit( 0 );
    }
    
    public JTextArea getWaitA() {
    	return waitTA;
    }
    
     
	
	public static void main(String[] args) throws IOException{
		TeamProEx cc = new TeamProEx( "localhost", "User");
        cc.init();
		
	}
}
