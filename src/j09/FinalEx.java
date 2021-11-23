package j09;

// 클래스에서 사용								다른 클래스에서 상속받을 수 없다.
//	메소드에서 사용								상속 관계에 있는 클래스에서 재정의 할 수 없다.
// 변수에서 사용									변수에 있는 값을 변경할 수 없다.

/*final */ class Finalsuper{
	final int a =10; 				//상수화.		//초기화 해야 한다. final 이 붙으면 생성자로 초기화 할 수 없다.
	public final int getA() {
		return a;
	}
 }											// final 은 static 으로 설정해야 메모리 낭비를 피할 수 있다...,.. 변할 필요없고,, 하나의 값으로 고정

public class FinalEx extends Finalsuper {		// final class 는 상속받을 수 없다.
	public int getA() { // final method 는 재정의 불가!
		return a;
	}
	public static void main(String[] args) {
		Finalsuper fs= new Finalsuper();
		//fs.a  =  20;				// final 은 고정값으로 쓴다.... 새로운 값 할당 불가능 ... Therefore 상수화!
		// 자연상수 e, pi .... 등이 final 로 상수화 돼있다.
	}
}
