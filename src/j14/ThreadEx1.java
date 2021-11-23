package j14;

// ������ �켱����
// ������� �ü�� �������� �ο��Ǹ� ����
// ������¿��� �켱���� ����
class ThreadOne extends Thread{
	public void run() {
		for ( int i = 0 ; i < 10; i++) {
			System.out.println(i + " : " + "ThreadOne" );		
			try {
				Thread.sleep(1000);
			}catch( InterruptedException e) { // OS �� �����층�� �����ߴ�.....
				e.printStackTrace();
			}
		}
	}
}

class ThreadTwo extends Thread{
	public void run() {
		for ( int i = 0 ; i < 10; i++) {
			System.out.println(i + " : " + "ThreadTwo" );				
			try {
				Thread.sleep(1000);
			}catch( InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadThree extends Thread{
	public void run() {
		for ( int i = 0 ; i < 10; i++) {
			System.out.println(i + " : " + "ThreadThree" );		
			try {
				Thread.sleep(1000);
			}catch( InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadOne to = new ThreadOne();
		ThreadTwo tt = new ThreadTwo();
		ThreadThree tr = new ThreadThree();
		
		to.start();
		try {
		to.join();		// join �� thread �� ���� ������.												// ������� �����Ҳ��� thread�� �� ������ ����....
		}catch(InterruptedException e) {
			
		}
		tt.start();
		tr.start();

	}
}
