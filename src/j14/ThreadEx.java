package j14;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

// Thread

// ���μ���			��ǻ�Ϳ��� ���������� ����ǰ� �ִ� ��ǻ�� ���α׷��� ����. ( ������¿� �ִ� ���α׷�)
//							�޸� CPU�� �Ҵ���� ����
// ���μ���			���α׷� ó�����ִ� �ϵ����  cpu / gpu
// ��Ƽ ���μ���		���μ����� ���ÿ� ������ ����
// �ú��� �ý���		��ǻ�� �ڿ��� �ð������� �����Ͽ� ��� �����ϰ� ��. ( time sharing system)
// ��Ƽ �½�ŷ		�����۾��� �ټ��� ���μ������� cpu, �޸𸮵��� �����ڿ��� ������ ����Ѵ�.
// ��Ƽ ������		���μ��� - �ϳ��� ���α׷�
//							�ϳ��� ���α׷� �ȿ��� ���� �۾��� ***���ÿ�*** �ؾ��ϴ� ���
// 						���μ����� �ɰ��� ������� ����� ���  ( ���μ����� �ɰ��� ������)

// �����带 ����� ���
// 1 . Thread Ŭ���� ���
// 2.	Runnable �̶�� �������̽� ���

// class �ϳ��� ������ �ϳ�

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
