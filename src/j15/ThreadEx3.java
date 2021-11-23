package j15;

// 재고관리
class Bread {					// 빵 재고관리 클래스
	int cnt = 0;
	public synchronized void make() {				// ++
		if (cnt  < 10 ) {
			cnt ++;
			System.out.println("빵의 개수 : " + cnt);
			notify();				// 작업이 끝나고 다음 쓰레드에 알림
		} else {
			System.out.println("빵이 남는다.");
			try {
			wait();					// 강제로 끄집어낸다?------ 에러발생
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	public synchronized void sell() {				//--
		if (cnt  > 0 ) {
			cnt--;
			System.out.println("빵의 개수 : " + cnt);
			notify();
		} else {
			System.out.println("빵이 부족함");
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}

class BreadMaker extends Thread {
	private Bread bread;
	public BreadMaker(Bread bread) {
		this.bread = bread;
	}
	
	public void run() {
		for (int i=0; i<10; i++) {
			bread.make();
		}
	}
}

class BreadSeller extends Thread {
	private Bread bread;
	public BreadSeller ( Bread bread) {
		this.bread = bread;
	}
	public void run() {
		for (int i = 0 ; i<10 ; i++) {
			bread.sell();
		}
	}
}



public class ThreadEx3 {
	public static void main(String[] args) {
		Bread bread = new Bread();
		BreadMaker bm = new BreadMaker(bread);			// BreadMaker 와 BreadSeller 가 bread 란 객체를 공유함.
		BreadSeller bs = new BreadSeller (bread);
		bm.start();
		bs.start();
	}
}
