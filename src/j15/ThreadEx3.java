package j15;

// ������
class Bread {					// �� ������ Ŭ����
	int cnt = 0;
	public synchronized void make() {				// ++
		if (cnt  < 10 ) {
			cnt ++;
			System.out.println("���� ���� : " + cnt);
			notify();				// �۾��� ������ ���� �����忡 �˸�
		} else {
			System.out.println("���� ���´�.");
			try {
			wait();					// ������ �������?------ �����߻�
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	public synchronized void sell() {				//--
		if (cnt  > 0 ) {
			cnt--;
			System.out.println("���� ���� : " + cnt);
			notify();
		} else {
			System.out.println("���� ������");
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
		BreadMaker bm = new BreadMaker(bread);			// BreadMaker �� BreadSeller �� bread �� ��ü�� ������.
		BreadSeller bs = new BreadSeller (bread);
		bm.start();
		bs.start();
	}
}
