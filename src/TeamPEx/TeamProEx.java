package TeamPEx;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


class MultiClientThread extends Thread {
    private TeamProEx mc;
    private static boolean quiz = true;
    private static boolean qchat = false;
    private boolean[] end = new boolean[4];
    private static boolean rdy = true;
    
    
    public MultiClientThread( TeamProEx mc ){
        this.mc = mc; 
    }
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        
        String answer = null;
        int i = 0;	//	답 비교를 위한 변수
        int k =0;	//	답 비교를 위한 변수
        int rand=0;		// 랜덤을 위한 변수
        boolean isStop = false;
        while(!isStop){
            try{
                message = (String)mc.getOis().readObject();
                if(message.contains("#")) {			//채팅부분
                	receivedMsg = message.split( "#" );
                	
                		System.out.println(receivedMsg[0] +" : "+receivedMsg[1]);
                	
                }else if( message.contains("@")){		//퀴즈 부분
                	receivedMsg = message.split( "@" );
                	
                	answer = receivedMsg[1];
                	System.out.println("answer : "+answer);
                	i= mc.getAnswer(answer,mc.getStr(k));			//퀴즈답으로 번호 
                	System.out.println("receivedMsg[0] : "+ receivedMsg[0]);
                	if(!(receivedMsg[0].equals("Timer"))) {
	                	if(mc.getStr(k)==i) {	//퀴즈 넘기고 
	                	if(k<4) {
	                			if(receivedMsg[0].equals(mc.getId())) {
	                				mc.setVisi(k);
	                    			mc.setQtext();
	                    			mc.setAnbl(k);
	                    			mc.popEnd("정답입니다.");
	                    			mc.getOOS().writeObject("DB&"+mc.getId());//본인이 맞췄을 경우 아이디를 서버로 보냄
	                			}else {
	                				mc.popEnd(receivedMsg[0]+"님께서 정답을 맞추셨습니다.");
	                				mc.setVisi(k);
	                    			mc.setQtext();
	                    			mc.setAnbl(k);
	                			}
	                			k++;
	                		}
	                	}else {
	                		mc.popEnd("오답입니다.");
	                		
	                	}
	                	qchat = true;
                	}
                	
               }else if(message.contains("☆")) {		//타이머 부분
            	   receivedMsg = message.split( "☆" );
            	   
               }else if(message.contains("★")) {	//회원가입
            	   System.out.println("회원가입 시작 클라이언트");
            	   receivedMsg = message.split( "★" );
               }else if(message.contains("&")) {//로그인 
            	   System.out.println("로그인 시작 클라이언트");
            	   receivedMsg = message.split( "&" );
               }
            }catch(Exception e){
                e.printStackTrace();
                isStop = true; 
            }
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
            	}else if(receivedMsg[0].equals("System")){ // 타이머 출력 및 퀴즈 설정 부분
            		
            		if(quiz) {
            			quiz=mc.setStart();
            			if(rdy) {
            				mc.rdyBtn();
            				rdy = false;
            			}
            			
            		}
            		if(receivedMsg[1].equals("제한시간종료")) {
            			mc.setTime(receivedMsg[1]);
	            		if(end[0]&&end[1]&&end[2]&&end[3])
	        			{
	        				mc.popEnd("축하드립니다. 탈출에 성공하셨습니다.\n"+"확인을 누르시면 게임을 종료합니다.");
	        				mc.sysEnd();
	        			}else {
	        				mc.popEnd("탈출에 실패하였습니다.\n"+ "확인을 누르시면 게임을 종료합니다.");
	        				mc.sysEnd();
	        			}
            		}else {
            			mc.setTime(receivedMsg[1]);
            			System.out.println(receivedMsg[0] +" : "+receivedMsg[1]);
            		}
            		
        		}else if(receivedMsg[0].equals("Quiz")){	 //퀴즈 랜덤 및 함정 부분
        			
        			if(rand<4) {
        				mc.setStr(receivedMsg[1],rand++);
        			}
        			
        			System.out.println(receivedMsg[1]);
        		}else if(receivedMsg[0].equals("Timer")){
        			if(receivedMsg[1].equals("함정발동")) {
        				mc.getJta().append(
            	                receivedMsg[0] +" : 함정을 누르셨습니다."+
            	                System.getProperty("line.separator"));
            	                mc.getJta().setCaretPosition(
            	                    mc.getJta().getDocument().getLength());
        			}else if(receivedMsg[1].equals("불가")) {
        				mc.getJta().append(
            	                receivedMsg[0] +" : 시간이 얼마 남지않아 함정이 발동되지 않습니다."+
            	                System.getProperty("line.separator"));
            	                mc.getJta().setCaretPosition(
            	                    mc.getJta().getDocument().getLength());
        			}
        			
        		}else if(receivedMsg[0].equals("DB")) {
        			if(receivedMsg[2].equals(mc.getId())) {
	        			 if(receivedMsg[1].equals("DB_rej")){	//사용불가 아이디
	            			mc.popSign("사용할 수 없는 아이디입니다.");
	            			mc.setTF();
	            		}else if(receivedMsg[1].equals("DB_ecep")){//DB오류
	            			mc.popSign("데이터베이스 오류로인한 회원가입 불가");
	            			
	            		}else if(receivedMsg[1].equals("DB_com")){//회원가입 완료 
	            			if(receivedMsg[2].equals(mc.getTf())) {
	            				System.out.println("회원가입 완료");
	//                			mc.popSign("회원가입이 완료되었습니다.");
	                			mc.setName(mc.getId());
	                			mc.setTF();
	                			mc.popStory();
	            			}else {
	            				mc.getJta().append(
	            						receivedMsg[2] +"님이 입장하셨습니다. "+
	            		                System.getProperty("line.separator"));
	            		                mc.getJta().setCaretPosition(
	            		                    mc.getJta().getDocument().getLength());
	            			}
	            		}else if(receivedMsg[1].equals("DB_sign")){ //로그인 성공
	            			if(receivedMsg[2].equals(mc.getTf())) {
	            				System.out.println("회원가입 완료");
	//                			mc.popSign("회원가입이 완료되었습니다.");
	                			mc.setName(mc.getId());
	                			mc.setTF();
	                			mc.popStory();
	            			}else {
	            				mc.getJta().append(
	            						receivedMsg[2] +"님이 입장하셨습니다. "+
	            		                System.getProperty("line.separator"));
	            		                mc.getJta().setCaretPosition(
	            		                    mc.getJta().getDocument().getLength());
	            			}
	            		}else if(receivedMsg[1].equals("DB_pass")){//비밀번호 다름
	            			mc.popSign("비밀번호가 다릅니다.");
	            		}else if(receivedMsg[1].equals("DB_non")){//아이디 다름
	            			mc.popSign("맞지않은 아이디입니다.");
	            		}
        			}
        		}else if(qchat) {
        			qchat = false;
        		}else{               
	                mc.getJta().append(
	                receivedMsg[0] +" : "+receivedMsg[1]+
	                System.getProperty("line.separator"));
	                mc.getJta().setCaretPosition(
	                    mc.getJta().getDocument().getLength());
	            }
            	
            	if(k>3) {
        			for(int j =0;j<end.length;j++) {
        				end[j] = mc.getAnbl(j);
        			}
        			if(end[0]&&end[1]&&end[2]&&end[3])
        			{
        				mc.popEnd("축하드립니다. 탈출에 성공하셨습니다.");
        				mc.sysEnd();
        			}else {
        				mc.popEnd("탈출에 실패하였습니다.");
        				mc.sysEnd();
        			}
        			System.out.println("게임종료");
        		}
               
            }//while 
        
    }//run() method
}// 쓰레드 클래스



public class TeamProEx implements ActionListener{
	
	// 퀴즈 프레임 및 이미지 넣기
	private JFrame jf3 = new JFrame();	//퀴즈 프레임
	private JPanel qap[] = new JPanel[4];
	private Image[] qimg=new Image[19];	// 퀴즈 이미지
	private JLabel[] qlab=new JLabel[19];	// 이미지 붙이는 라벨
	private JPanel qp;		//정답 입력 버튼, 필드 붙이는 패널
	private JButton qbtn;	// 정답 입력 버튼
	private JTextField qtf;	// 정답 입력 필드
	private String[] str=new String[] {"0","0","0","0"};				//랜덤값 저장 
	private int me,my;		//마우스 위치 값 저장
	private boolean popup = false;		//퀴즈 프레임 ON/OFF를 위한 변수
	private boolean[] anbl = new boolean[4];		//퀴즈 라벨 On/Off를 위한 변수
	private boolean[] anbl2 = new boolean[4];	// 탈출여부 확인을 위한 변수
	private int[] ans = new int[19] ;					// 정답비교를 위한 변수
	private boolean[] anbl3 = new boolean[4];	//힌트를 위한 변수
	private  boolean p=true;
	private  boolean pp=false;
	//아이디 패스워드 프레임
	private JFrame jf2;
	private JPanel waitP= new JPanel();	// 패널 합치는 패널
	private JPanel waitPN = new JPanel();// 라벨 넣고 위쪽 배치한 패널
	private JLabel waitL;	//설명 라벨
	private JPanel waitPC = new JPanel();	// 아이디, 패스워드 확인버튼 패널
	private JPanel waitPP = new JPanel();	//아이디 라벨 패널
	private JLabel waitPPL;		//아이디 라벨
	private JTextField waitTF = new JTextField();		//아이디 입력받기
	private JPanel waitPP2 = new JPanel();	//패스워드 라벨 패널
	private JLabel waitPPL2;		//패스워드 라벨
	private JPasswordField waitTF2 = new JPasswordField();	//패스워드 입력받기
	private JButton waitB = new JButton("확인");			// 아이디 패스워드 입력 후 확인버튼
	private ButtonGroup rdbg = new ButtonGroup();
	private JRadioButton rdb1 = new JRadioButton("회원가입",true);
	private JRadioButton rdb2 = new JRadioButton("로그인");
	
	private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String ip;					//아이피
    private String id;					//닉네임
    private String passwd;
    
    // 게임 진행 프레임
    private JFrame jf1;
    private JButton NaBtn = new JButton("\uC900\uBE44");	//준비버튼
    private JLabel NaLb = new JLabel("Myname",SwingConstants.RIGHT);		//내 이름 나타내는 라벨
    private JPanel panel = new JPanel(); 						// 채팅입력 필드, 입력 버튼, 종료 버튼 붙이는 패널
    private JButton ChBtn = new JButton("\uC785\uB825");	//입력 버튼.
    private JButton ChEBtn = new JButton("\uC885\uB8CC");				// 종료 버튼
    private JTextArea ChTa = new JTextArea();								//입력한 채팅 나타나는 TextArea
    private JTextField ChTp= new JTextField();	// 채팅부분 텍스트 필드
    
    private JPanel ChatP ;		//채팅 패널	
	private JPanel ImageP ;	// 이미지 패널
	private JLabel bglab;
	private Image bgimg;		//기본 맵 이미지
	
	
	private JPanel NameP ;		// 자신의 닉네임 패널
	private JPanel TimeP ;		// 타이머 패널
	private JLabel TmLb = new JLabel();  //타이머 라벨
	
	
	//스크린 사이즈 구하기.
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d =tk.getScreenSize();
	int screenHeight = d.height;
    int screenWidth = d.width;
    
	
	public TeamProEx(String argIp,String argId) {
		
        
		ip = argIp;
        id = argId;
        
        //퀴즈  프레임
        for(int i =0;i<19;i++) {
    		qimg[i]= new ImageIcon("src\\TeamPEx\\quiz\\quiz_"+(i+1)+".png").getImage().getScaledInstance(300, 200, 0);
    		ans[i]=i;
    }
    
    
    
//    for(int i=0;i<str.length;i++) {
//    	vs[i] = Integer.parseInt(str[i]);
//    }
	
    	
    
	jf3 = new JFrame();
	jf3.setResizable(false);
	for(int i=0;i<4;i++) {
		qap[i]= new JPanel();
		qap[i].setLayout(new BorderLayout());
		qlab[i] = new JLabel(new ImageIcon(qimg[Integer.parseInt(str[i])]));
		
		anbl[i]=false;
		anbl2[i]=false;
		
		qap[i].add(qlab[i],BorderLayout.CENTER);
	    
	 }
		
		anbl[0]=true;
    	qp = new JPanel();
    	 
    	qtf = new JTextField("",30);
    	qbtn = new JButton("확인");
    	 
    	 
    	qtf.addActionListener(this);
    	qbtn.addActionListener(this);
    	 
    	qp.add(qtf,BorderLayout.CENTER);
    	qp.add(qbtn,BorderLayout.EAST);
    	qap[0].add(qp,BorderLayout.SOUTH);
    	
	    
        
    	
        
    	 
        //로그인 관련 패널
        
       jf2 = new JFrame("접속");
       jf2.getContentPane().setLayout(new BorderLayout());
       waitL = new JLabel("사용하실 아이디와 비밀번호를 입력해주세요.");
       
       
       rdbg.add(rdb1);
       rdbg.add(rdb2);
        
       waitPN.add(waitL);
       waitPPL = new JLabel("아이디 : ");
       waitTF.setColumns(5);
       
       waitPP.setLayout(new GridLayout(1,2));
       waitPP.add(waitPPL);
       waitPP.add(waitTF);
       
       
       waitPPL2 = new JLabel("비밀번호 : ");
       waitTF2.setColumns(5);
       
       waitPP2.setLayout(new GridLayout(1,2));
       waitPP2.add(waitPPL2);
       waitPP2.add(waitTF2);
       
       waitPC.setLayout(new GridLayout(2,1));
       
       waitPC.add(waitPP);
       waitPC.add(waitB);
       waitPC.add(waitPP2);
      
       waitP.add(rdb1);
       waitP.add(rdb2);
       waitP.add(waitPN);
       waitP.add(waitPC);
       
       
       
       rdb1.addActionListener(this);
       rdb2.addActionListener(this);
       waitB.addActionListener(this);
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
                waitTF.requestFocus();
            }
        });
        
        jf2.getContentPane().add(waitP);

        
        
        jf2.setSize(new Dimension(350,200));
        jf2.setLocation(  (screenWidth - jf2.getWidth()) / 2,  (screenHeight - jf2.getHeight()) / 2);
		jf2.setVisible(true);
        jf2.setResizable(false);
        
        
        
        //게임플레이 패널 관련
		jf1 = new JFrame("방탈출");
		jf1.getContentPane().setBackground(Color.BLACK);
		
		 ChatP = new JPanel();		//채팅 패널	
		 ImageP = new JPanel();	// 이미지 패널
		 ImageP.setRequestFocusEnabled(false);
		 NameP = new JPanel();		// 자신의 닉네임 패널
		 TimeP = new JPanel();		// 다른 접속 유저의 패널
		 
		GroupLayout groupLayout = new GroupLayout(jf1.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(ImageP, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(ChatP, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addComponent(TimeP, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addComponent(NameP, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(NameP, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TimeP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ChatP, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(214)
							.addComponent(ImageP, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		
		TimeP.add(TmLb);
		
		bgimg = new ImageIcon("src\\TeamPEx\\MMD.png").getImage().getScaledInstance(1000, 700, 0);
		ImageP.setLayout(new BorderLayout(0, 0));
		bglab = new JLabel(new ImageIcon(bgimg));
		bglab.setEnabled(false);
		bglab.setIcon(new ImageIcon(bgimg));
		ImageP.add(bglab);
		ImageP.add(bglab);
		ImageP.setEnabled(false);
		

		NameP.setLayout(new GridLayout(1, 0, 0, 0));
				
		
		NaBtn.addActionListener(this);
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
		JScrollPane jsp = new JScrollPane( ChTa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setRequestFocusEnabled(false);
		ChatP.add(jsp, BorderLayout.CENTER);
		
		

		
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
		
		jf1.setSize(screenWidth/2,screenHeight/2);
		jf1.pack();
		jf1.setLocation(  (screenWidth - jf1.getWidth()) / 2,  (screenHeight - jf1.getHeight()) / 2);
		jf1.setVisible(true);
		jf1.setEnabled(false);
		jf1.setResizable(false);
		
		jf2.toFront();
	}
	 
	//이벤트 처리 부분.
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
        String msg = ChTp.getText();
        
        String waitmsg = waitTF.getText();	//아이디
        String waitmsg2 = null;
        waitmsg2= String.copyValueOf(waitTF2.getPassword());

        String answer = qtf.getText();
        System.out.println(waitmsg2);
        try {
        	
	        if ( obj == ChTp ||obj == ChBtn) {	//채팅
	            if ( msg == null || msg.length()==0 ) {
	                JOptionPane.showMessageDialog( jf1, "글을쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
	            } else {
                    oos.writeObject( id + "#" + msg );
	                ChTp.setText("");
	            }
	            
	        } else if ( obj == ChEBtn ) {		//종료버튼
	            oos.writeObject( id + "#exit" );
	            System.exit( 0 );
	            
	        }else if(obj == waitB || obj == waitTF2){		// 로그인창 버튼
	        	
	        	
	        	if(rdb1.isSelected()) {	//회원가입 버튼
	        		if ( waitmsg == null || waitmsg.length()==0 ) {
	                    JOptionPane.showMessageDialog( jf2, "아이디를 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
	                }else if(waitmsg2 == null || waitmsg2.length()==0){
	                	JOptionPane.showMessageDialog( jf2, "비밀번호를 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
	        		}else if(waitmsg.contains("System") || waitmsg.contains("Quiz") ||waitmsg.contains("Timer")||waitmsg.contains("DB")){
	        			JOptionPane.showMessageDialog( jf2, "사용할 수 없는 아이디입니다.", "경고", JOptionPane.WARNING_MESSAGE);
	        		}else if(!checkId(waitmsg)){
	        			JOptionPane.showMessageDialog( jf2, "아이디에는 특수문자 입력이 불가합니다.", "경고", JOptionPane.WARNING_MESSAGE);
	        		}else if(!checkPasswd(waitmsg2)) {
	        				JOptionPane.showMessageDialog( jf2, "비밀번호는 숫자만 입력가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
	        		}
	        		else {
	        				this.id =waitmsg; 
		        			this.passwd = waitmsg2;
		        			oos.writeObject( id + "★"+ waitmsg2  );	//아이디 패스워드 넘기는 부분.
	        		}
	        	}else if( rdb2.isSelected()) {	//로그인 버튼
	        		 if(!checkId(waitmsg)){
	        			JOptionPane.showMessageDialog( jf2, "아이디에는 특수문자 입력이 불가합니다.", "경고", JOptionPane.WARNING_MESSAGE);
	        		}else if(!checkPasswd(waitmsg2)) {
	        				JOptionPane.showMessageDialog( jf2, "비밀번호는 숫자만 입력가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
	        		}else if(waitmsg  == null || waitmsg.length() == 0) {
        				JOptionPane.showMessageDialog( jf2, "아이디를 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
	        		}else if(waitmsg.contains("System") || waitmsg.contains("Quiz") ||waitmsg.contains("Timer")||waitmsg.contains("DB")){
	        			JOptionPane.showMessageDialog( jf2, "사용할 수 없는 아이디입니다.", "경고", JOptionPane.WARNING_MESSAGE);
	        		}else {
		        		this.id =waitmsg; 
	        			this.passwd = waitmsg2;
	        			oos.writeObject( waitmsg + "&"+ waitmsg2  );
	        		}
	        	}
	        }else  if(obj == NaBtn) {		// 게임화면 준비버튼
	       
	        	oos.writeObject( id + "☆"+"님 준비완료"   );
	        	NaBtn.setEnabled(false);
	        	
	        }else if(obj == qbtn || obj == qtf){	// 퀴즈 정답 입력창
	        	if ( answer == null || answer.length()==0 ) {
                    JOptionPane.showMessageDialog( jf3, "정답을 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                    qtf.requestFocus();
                }else{	        	
                	oos.writeObject( id + "@" + answer );
                }
	        	
	        }//if문
	        
	        
        }catch (IOException ee) {
			ee.printStackTrace();
		}

	}//이벤트 처리기 
	
	public void init() throws IOException {
        socket = new Socket( "124.49.110.15" , 3000 );			// ip
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
	public ObjectOutputStream getOOS() {
		return oos;
	}
	
    public JTextArea getJta(){
        return ChTa;
    }
    
    public String getId(){	//아이디 불러오기
        return id;
    }
    
    public String getPasswd() {	//패스워드 불러오기
    	return passwd;
    }
    
    public void exit(){
        System.exit( 0 );
    }
    public void setName(String id) { // 자신이 입력한 아이디로 닉네임 전환  메소드
    	NaLb.setText(id);
    	jf2.setVisible(false);
    	jf1.toFront();
    	jf1.setEnabled(true);

    }
    public boolean checkId(String id) {		//아이디에 한글, 영문, 숫자만 입력받게 함.
    	boolean check=true;
    	char ch;
    	for(int chk=0;chk<id.length();chk++) {
    		ch=id.charAt(chk);
	    	 if((ch >= 0x41 && ch<=0x5A )||(ch >= 0x61 && ch<=0x7A ) ||(ch>=0xAC00 && ch<=0xD7FF)||(ch >=0x30 && ch<=0x39)) {
	    		 check= true;
	    	 }else {
	    		 check= false;
	    		 break;
	    	 }
    	}
    	 return check;
    }
    
    public boolean checkPasswd(String passwd) { //비밀번호에 숫자만 입력받게 함.
    	boolean check=true;
    	char ch;
    	for(int chk=0;chk<passwd.length();chk++) {
    		ch=passwd.charAt(chk);
	    	 if((ch >=0x30 && ch<=0x39)) {
	    		 check= true;
	    	 }else {
	    		 check= false;
	    		 break;
	    	 }
    	}
    	 return check;
    }
    
    public String getName() {//아이디 얻어오는 메서드
    	return id;
    }
    public void setTime(String time) {	//타이머 출력 메소드
    	if(time.equals("제한시간종료")) {
    		TmLb.setText(time);
    	}else {
    		TmLb.setText("남은시간 : "+(Integer.parseInt(time)/60)+"분"+(Integer.parseInt(time)%60)+"초");	
    	}
    }
    
    public int getAnswer(String answer,int qu) {
    	
    	if(answer.equals("2")) {	//quiz_1
    		
    		this.popup = false;
    		return ans[0];
    	}else if(answer.equals("58")) { // quiz_2
    		
    		this.popup = false;
    		return ans[1];
    	}else if(answer.equals("5148")) { // quiz_3
    		
    		this.popup = false;
    		return ans[2];
    	}else if((answer.equals("E") || answer.equals("e"))&& qu == 3) { // quiz_4
    		
    		this.popup = false;
    		return ans[3];
    	}else if(answer.equals("106")) { // quiz_5
    		
    		this.popup = false;
    		return ans[4];
    	}else if(answer.equals("1")) { // quiz_6
    		
    		this.popup = false;
    		return ans[5];
    	}else if(answer.equals("5")) { // quiz_7
    		
    		this.popup = false;
    		return ans[6];
    	}else if(answer.equals("6")&& qu == 7) { // quiz_8
    		
    		this.popup = false;
    		return ans[7];
    	}else if((answer.equals("6시") || answer.equals("6"))&& qu == 8) { // quiz_9
    		
    		this.popup = false;
    		return ans[8];
    	}else if(answer.equals("0013")) { // quiz_10
    		
    		this.popup = false;
    		return ans[9];
    	}else if(answer.equals("410")) { // quiz_11
    		
    		this.popup = false;
    		return ans[10];
    	}else if(answer.equals("129")) { // quiz_12
    		
    		this.popup = false;
    		return ans[11];
    	}else if(answer.equals("1204")) { // quiz_13
    		
    		this.popup = false;
    		return ans[12];
    	}else if(answer.equals("91912399")) { // quiz_14
    		
    		this.popup = false;
    		return ans[13];
    	}else if(answer.equals("ESCAPE")||answer.equals("escape")) { // quiz_15
    		
    		this.popup = false;
    		return ans[14];
    	}else if(answer.equals("HELP") || answer.equals("help")) { // quiz_16
    		
    		this.popup = false;
    		return ans[15];
    	}else if(answer.equals("3295")) { // quiz_17
    		
    		this.popup = false;
    		return ans[16];
    	}else if(answer.equals("A") || answer.equals("a")) { // quiz_18
    		
    		this.popup = false;
    		return ans[17];
    	}else if((answer.equals("E") || answer.equals("e"))&& qu == 18) { // quiz_19
    		
    		this.popup = false;
    		return ans[18];
    	}else {
    		System.out.println("정답 틀림.");
    		this.popup = true;
    		return 19;
    	}
    	
    } // 답 구하는 메서드
   
    public void setVisi(int i) {
    	if(i<3) {
    		this.anbl3[i]=true;
    		this.anbl[i+1]=true;
    		this.anbl[i]=false;
    		jf3.setVisible(anbl[i]);
    	}else if(i==3) {
    		this.anbl[i]=false;
    		jf3.setVisible(anbl[i]);
    	}
   	}
    
    public void setImg(int i) {
    	jf3 = new JFrame();
    	qlab[i].setIcon(new ImageIcon(qimg[Integer.parseInt(str[i])]));
    	qap[i].add(qp,BorderLayout.SOUTH);
    	jf3.getContentPane().add(qap[i]);
	    jf3.setSize(500,500);
	    jf3.setLocation((screenWidth - jf3.getWidth()) / 2,  (screenHeight - jf3.getHeight()) / 2);
	    
    }
    
    public void setQtext() {
    	this.qtf.setText("");
    }
    public void setStr(String str,int i) {
    	if(i<4) {
    		this.str[i] = str;
    	}
    	
    }
    public int getStr(int i) {
    	return Integer.parseInt(this.str[i]);
    }
    public void setAnbl(int i) {
    	this.anbl2[i]=true;
    }
    public boolean getAnbl(int i) {
    	return this.anbl2[i];
    }
    public void popEnd(String str) {	//퀴즈 안내 창 
    	if(str.equals("오답입니다.")) {
    		JOptionPane.showMessageDialog(jf3, str);
    	}else if(str.equals("정답입니다.")){
    		JOptionPane.showMessageDialog(jf3, str);
    	}else {
    		JOptionPane.showMessageDialog(jf1, str);
    	}
    	
    }
    public void popStory() {
    	JOptionPane.showMessageDialog(jf1, "대저택에 초대받은 당신과 동료들. \n"
    			+ "하지만 저택에 들어서는 순간 문이 잠기고 제한시간 안에\n "
    			+ "저택 곳곳에 숨겨진 단서를 찾아 함께 저택을 탈출해야만 한다.\r"
    			
    			,"스토리",JOptionPane.YES_OPTION);
    }
    public void popSign(String str) {	//로그인 및 회원가입 안내 창 
    	JOptionPane.showMessageDialog(jf2, str);
    	this.jf2.setVisible(true);
    }
    public String getTf() {
    	return waitTF.getText();	
    }
    
    public void rdyBtn() {
    	NaBtn.setEnabled(false);
    }
    
    
    public void setTF() {	//회원가입 완료 혹은 로그인 완료 시 TextField 초기화
    	waitTF.setText("");
        waitTF2.setText("");
    }
    
    
    public void sysEnd() {
    	System.exit(0);
    }
    
    public boolean setStart() {
    	
	    	this.bglab.setEnabled(true);
	    	this.ImageP.setEnabled(true);
	    	this.ImageP.setVisible(true);
	    	
	    	ImageP.addMouseListener(	// 퀴즈 프레임 띄우는 마우스 이벤트
					new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							try {
								
								 me = e.getX();	//마우스 X좌표 값.
								 my = e.getY();	// 마우스 Y좌표 값.
								 if( (me >=855 && me <=900) && (my >=335 && my <=360) ) {	//맨 오른쪽 책꽂이
									 if( anbl[0] ) {
										 setImg(0);
										 popup = true;	// 퀴즈 프레임 팝업을 위한 변수 값.
										 if(p) {
											 jf3.setVisible(popup); // 퀴즈 프레임 노출
											 jf3.toFront();
											 p=false;
										 }
										 qtf.requestFocus();
									 }else {
										 JOptionPane.showMessageDialog(ImageP, "hint : ㅅㅈ");
										 p=true;
									 }
								 }else if((me >=440 && me <=500) && (my >=190 && my <=240)) { //중앙 그림 밑 상자
									 if( anbl[1] ) {
										 setImg(1);
										 qtf.requestFocus();
										 popup = true;	// 퀴즈 프레임 팝업을 위한 변수 값.
										 if(p) {
											 jf3.setVisible(popup); // 퀴즈 프레임 노출
											 jf3.toFront();
											 p=false;
										 }
										 
									 }else if(anbl3[1]){
										 JOptionPane.showMessageDialog(ImageP, "hint : ㅅㄹㅈ ");
										 p=true;
									 }
								 }else if((me >=380 && me <=435) && (my >=165 && my <=245)) { // 상자 옆 서랍장
									 if( anbl[2] ) {
										 setImg(2);
										 qtf.requestFocus();
										 popup = true;	// 퀴즈 프레임 팝업을 위한 변수 값.
										 if(p) {
											 jf3.setVisible(popup); // 퀴즈 프레임 노출
											 jf3.toFront();
											 p=false;
										 }
									 }else if(anbl3[2]){
										 JOptionPane.showMessageDialog(ImageP, "hint : ㅎㅇㄹ");
										 p=true;
									 }
								 }else if((me >=580 && me <=625) && (my >=275&& my <=325)) { // 계단 밑 항아리
									 if( anbl[3] ) {
										 qtf.requestFocus();
										 setImg(3);
										 popup = true;	// 퀴즈 프레임 팝업을 위한 변수 값.
										 if(p) {
											 jf3.setVisible(popup); // 퀴즈 프레임 노출
											 jf3.toFront();
											 p=false;
										 }
									 }
								 }else if((me >=640 && me <=675) && (my >=285 && my <=335)) { // 계단 밑 항아리 함정
									 oos.writeObject("Timer@함정발동");
								 }else if((me >=170 && me <=180) && (my >=270 && my <=280)) { // 맨 왼쪽 진열대 와인병 밑 함정
									 oos.writeObject("Timer@함정발동");
								 }else if(pp) {
									 p=true;
									 pp = false;
								 }
								 
							}catch(IOException ee) {
								ee.printStackTrace();
							}finally {
								jf3.addWindowListener( new WindowAdapter() {
						            public void windowClosing( WindowEvent e) {
						            	setP();
						            	pp=true;
						                jf3.setVisible(false);
						            }
						        });
							}
						}
					}
			);
	    	System.out.println("이미지패널 실행");
	    	
	    	
	    	return false;
    	
    }// 퀴즈 프레임
    public void setP() {
    	p =true; 
    }
    
     
	
	public static void main(String[] args) throws IOException{
		TeamProEx cc = new TeamProEx( "124.49.110.15", "User");
        cc.init();
		
	}
}
