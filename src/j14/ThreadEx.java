package j14;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

// Thread

// 프로세스			컴퓨터에서 연속적으로 실행되고 있는 컴퓨터 프로그램을 말함. ( 실행상태에 있는 프로그램)
//							메모리 CPU를 할당받은 상태
// 프로세서			프로그램 처리해주는 하드웨어  cpu / gpu
// 멀티 프로세스		프로세스가 동시에 여러개 실행
// 시분할 시스템		컴퓨터 자원을 시간적으로 분할하여 사용 가능하게 함. ( time sharing system)
// 멀티 태스킹		다중작업은 다수의 프로세스들이 cpu, 메모리동의 공용자원을 나누어 사용한다.
// 멀티 쓰레드		프로세스 - 하나의 프로그램
//							하나의 프로그램 안에서 여러 작업을 ***동시에*** 해야하는 경우
// 						프로세스를 쪼개서 쓰레드로 만들어 사용  ( 프로세스를 쪼개면 쓰레드)

// 쓰레드를 만드는 방법
// 1 . Thread 클래스 상속
// 2.	Runnable 이라는 인터페이스 상속

// class 하나가 쓰레드 하나

class ThreadConsole extends Thread{
	public void run() {
		int cnt = 0;
		while ( true ) {
			System.out.println(++cnt);
		}
	}
}

class ThreadWindow extends JFrame implements Runnable {
	JLabel la = new JLabel("",JLabel.CENTER);
	public ThreadWindow() {
		add( la );
		setBounds(500,200,200,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void run() {		
		while(true) {
			Calendar now = Calendar.getInstance();
			String time = now.get(Calendar.HOUR_OF_DAY) + " : " + now.get(Calendar.MINUTE) + " : " +
								 now.get(Calendar.SECOND);
			la.setText( time );		
		}
	}
}


public class ThreadEx {
	public static void main(String[] args) {
		ThreadConsole tc = new ThreadConsole();
		tc.start();
		
		ThreadWindow tw = new ThreadWindow();
		Thread t = new Thread (tw);
		t.start();
	}
}
