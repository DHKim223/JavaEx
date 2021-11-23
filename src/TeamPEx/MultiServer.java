package TeamPEx;

import java.net.*;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.Timer;
import TeamPEx.DbLink;

class MultiServerThread implements Runnable {
    private Socket socket;
    private MultiServer ms;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private static int i=0,j=0;
//    private static String[] rand = new String[4];
    private static String[] rand = new String[19];
    
    private Timer stopwatch;
	private static int count=0;
	private int delay =1000;
	private static boolean ff= true;
	private DbLink dblink = new DbLink();
	
	
    public MultiServerThread( MultiServer ms ){
        this.ms = ms;
        
    }
    public synchronized void run(){
        boolean isStop = false;
        if(ff) {
        	setRandom();
        }
        
        try{
            socket = ms.getSocket();
            ois = new ObjectInputStream( socket.getInputStream() );
            oos = new ObjectOutputStream( socket.getOutputStream() );
            String message = null;
            String idmsg;
            String[] com = null;
            dblink.getConnection();
            
            
            
            
            while( !isStop ){
                message = ( String )ois.readObject();
                if(message.contains("#")) {	//채팅
                	String[] str = message.split( "#" );
                	if(i<j) {
                    	j--;
                    }
                	if( str[1].equals( "exit" ) ){
                		i--;
                        if(j!=0 && j>=0) {
                        	j--;
                        }
                        broadCasting( message );
                        isStop = true;
                    }else{
                        broadCasting( message );
                    }
                }else if( message.contains("@")){	//답 혹은 함정.
                	String[] str = message.split( "@" );
                	if(str[0].equals("Timer")&& count>40) {
                		broadCasting( "Timer@함정발동" );
                		count -=20;
                	}else if(str[0].equals("Timer")&& count<40) {//함정 처리 불가
                		broadCasting( "Timer@불가" );
                	}else {
                		broadCasting( message+"@QQ" );
                	}
                	
                }else if(message.contains("☆")) {	//타이머 
                	broadCasting( message );
                	j++;
                	System.out.println("i : "+i+ "j : "+j);
                	if(i ==j) {
                		startTimer(600);
                	}
                }else if(message.contains("★")) {		//회원가입
                	System.out.println("회원가입 시작 서버");
                	String[] resi = message.split( "★" );
                	dblink.getConnection();
                	idmsg=dblink.register(resi[0], resi[1]);
                	
                	com = idmsg.split("★");
                	dblink.Close();
                	if(com[1].equals("DB_com")) {
	                	for(int i =0; i<4;i++) {
	                		System.out.println("rand["+i+"] : "+ rand[i]);
	                    	broadCasting("Quiz#"+rand[i]);
	                    }//랜덤함수 뿌리기
	                	
	                	broadCasting(idmsg+"★"+resi[0]);
	                	i++;
                	}else {
                		broadCasting(idmsg);
                	}
                	System.out.println("회원가입끝 시작 서버");
                }else if(message.contains("&")) {	//로그인
                	
                	System.out.println("로그인 시작 서버");
                	String[] sign = message.split( "&" );
                	if(sign[0].equals("DB")) {
                		dblink.getConnection();
                		dblink.Score(sign[1]);
                		dblink.Close();
                	}else {
                		dblink.getConnection();
                    	idmsg=dblink.signin(sign[0], sign[1]);
                    	com = idmsg.split("&");
                    	dblink.Close();
                	
                	
                	
                	if(com[1].equals("DB_sign")) {
	                	for(int i =0; i<4;i++) {
	                    	broadCasting("Quiz#"+rand[i]);
	                    }//랜덤함수 뿌리기
	                	broadCasting(idmsg+"&"+sign[0]);
	                	i++;
	                	System.out.println(i+"회차"+"i : "+i+ "j : "+j);
                	}else{
                		broadCasting(idmsg);
                	}
                		
                	}
                	System.out.println("로그인 끝 서버");
                }
                
            }     //while
            
            ms.getList().remove( this );
            System.out.println( socket.getInetAddress() + "정상적으로 종료하셨습니다." );
            System.out.println( "list size : " + ms.getList().size() );
            
        }catch(Exception e){
        	e.printStackTrace();
            ms.getList().remove( this );
            System.out.println( socket.getInetAddress() + "비정상적으로 종료하셨습니다." );
            System.out.println( "list size : "+ms.getList().size() );
            i--;
            if(j!=0 && j>=0) {
            	j--;
            }
        }
    }
    public void broadCasting( String message ) throws IOException{
        for( MultiServerThread ct : ms.getList() ){
           ct.send( message );
        }
    }
    public void send( String message )throws IOException{
        oos.writeObject( message );        
    }
    
    public void startTimer(int countPassed) {
    	ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(count ==0) {
						stopwatch.stop();
						broadCasting("System"+"#"+"제한시간종료");
					}else {
						broadCasting("System"+"#"+count);
						count--;
					}
				}catch (IOException ee) {
					ee.printStackTrace();
				}
			}
		};
		stopwatch = new Timer(delay, action);
		stopwatch.setInitialDelay(0);
		stopwatch.start();
		count=countPassed;
		
	} // 타이머
    
//    public void setRandom() {
//    	for(int i =0 ; i<rand.length;i++) {
//    		rand[i]=String.valueOf((int)(Math.random()*19));
//			
//			System.out.println("str["+i+"]"+rand[i]);
//		}
//    
//   
//    	for(int i = 0; i<rand.length;i++) {
//    		for(int j=i+1;j<rand.length;j++) {
//				if(rand[i].contentEquals(rand[j])) {
//					rand[i]=String.valueOf((int)(Math.random()*19));
//					
//					System.out.println("str["+i+"]"+rand[i]);
//				}else {
//					
//				}
//			}
//		}
//    this.ff = false;
//    } // 랜덤 함수 제작 메서드
    
    
    public void setRandom() {
    	for(int i=0; i<rand.length;i++) {
    		rand[i]=String.valueOf(i);
    	}
    	List<Object> list = new ArrayList<Object>();
    	Collections.shuffle(Arrays.asList(rand));
    	ff=false;
    }//셔플 함수 제작 메서드
    
    
}//Thread
public class MultiServer {
	private ArrayList< MultiServerThread > list;
	private Socket socket;
	public MultiServer() throws IOException {
		list = new ArrayList < MultiServerThread >();
		ServerSocket serverSocket = new ServerSocket( 3000 );
		MultiServerThread mst = null;
		boolean isStop = false;
		while( !isStop ){
				System.out.println( "Server read..." );
				socket = serverSocket.accept();
				mst = new MultiServerThread( this );
				list.add( mst );
				Thread t = new Thread( mst );
				t.start();
		}
	}
	public ArrayList< MultiServerThread > getList() {
		return list;
	}
	public Socket getSocket() {
		return socket;
	}
	
	
	
	public static void main( String args[] ) throws IOException {
		new MultiServer();
	}
}

