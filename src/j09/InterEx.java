package j09;

// 인터페이스 Interface
// interface 키워드를 사용한다
// 상수( final 변수) 와 추상 메소드로만으로 구성된다.
//	final, abstract 키워드를 따로 붙이지 않는다.
// interface는 객체를 생성할 수 없다.
// 상속 시 implements(구현) 키워드를 사용한다.
// 상속 시 추상 메소드는 빠짐없이 구현해야 한다.
// 다중 상속이 가능하다.

interface Inter1 {
	int a = 10;										// final static 이기때문에 초기화 반드시 해야한다.
	public int getA();								// abstract 					  구현할 수 없다.	
}



public class InterEx implements Inter1 {
	public int getA() {
		return a;
	}
	public static void main(String[] args) {
		//Inter1 in = new Inter1();						// 객체를 생성할 수 없음_____미완성이기 때문에
		InterEx ie = new InterEx();
		System.out.println(ie.getA());
	}
}
