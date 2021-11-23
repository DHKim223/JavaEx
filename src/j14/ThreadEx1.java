package j14;

// 쓰레드 우선순위
// 쓰레드는 운영체제 스케쥴이 부여되면 실행
// 경쟁상태에서 우선순위 조절
class ThreadOne extends Thread{
	public void run() {
		for ( int i = 0 ; i < 10; i++) {
			System.out.println(i + " : " + "ThreadOne" );		
			try {
				Thread.sleep(1000);
			}catch( InterruptedException e) { // OS 의 스케쥴링을 방해했다.....
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
		to.join();		// join 한 thread 를 먼저 끝낸다.												// 순서대로 실행할꺼면 thread를 쓸 이유가 없지....
		}catch(InterruptedException e) {
			
		}
		tt.start();
		tr.start();

	}
}
