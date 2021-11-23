package j09;

// 추상클래스 Abstract
// 추상 메서드를 하나라도 가지면 추상 클래스가 된다.
// 추상 메서드는 구현하지 않는다.
//	추상 크래스임을 명시해야 한다.
//	객체를 생성할 수 없다. 항상 상속으로 구현된다.
// 상속 시 추상 메소드는 구현해야 한다.
// 일반 변수 메서드 상수를 가질 수 있다.

// 하위 클래스에 제약을 걸기 위해서 / 틀을 정한다.

// abstract 추가 /추상메서드를 구현하거나
abstract class AbstractSuper{	 // 추상클래스 			abstract를 명시해야한다.
	int a = 10;
	public abstract int getA();		// 추상메서드는 구현할 수 없다.
}						// 포함하고 있는 추상클래스의 자식클래스	추상메서드를 복제하기 위해서

public class AbstractEx extends AbstractSuper {
	public int getA() {						// 오버라이드 해야한다.
		return a;
	}
	public static void main(String[] args) {
	
		
		// 1. 객체생성 //2. 상속 3. 멤버가 static 인지 확인 
		//AbstractSuper as = new AbstractSuper();		// 추상 클래스는 객체 생성이 안된다.
		//AbstractSuper as;  		//참조변수는 생성할 수 있다.  하지만 new (heap 영역에 메모리 할당) 는 안된다. 
																						// 추상메서드가 미완성이기 때문에
																						// 객체생성이 불가능 하기 때문에 상속 받아야한다.
		
		
		
		
	}
}
