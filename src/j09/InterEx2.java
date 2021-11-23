package j09;

// 인터페이스 사용
// 직접 implements 해서 추상메서드를 재정의 해서 사용
// 대신 구현한 클래스를 extends 해서 필요한 메서드만 재정의 해서 사용

interface Inter4 { 
	int d= 40;
	public int getD();
}

interface Inter5 extends Inter4 { 
	int e= 50;
	public int getE();
}

// 아답터 클래스 ____ 인터페이스를 대신 구현하는 클래스
abstract class InterSuper implements Inter5{		// 구현하지 않으면 추상클래스가 되고 메인클래스에서 구현해야함.
//	public int getD() {
//		return d;
//	}
//	public int getE() {
//		return e;
	
	// 객첵를 생성하지 말것 __ 대신 구현만 하지 실행은 하지 않는다.
	public int getD() {
		return d;
	}
	public int getE() {
		return e;
	}
//	}
}

public class InterEx2 extends InterSuper{
	// 대신 구현한 클래스의 필요한 메서드만 제헝의
	public static void main(String[] args) {
		public int getD() {
			return d;
		}
		public int getE() {
			return e;
		}
	}
}
