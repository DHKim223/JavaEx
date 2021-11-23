package j10;

// 자료형에 한정되지 않고 사용___ 자료형을 미리 정하지 않고 사용.

//class Generic{
//	private int a;
//	public Generic( int a ) {
//		this.a = a;
//	}
//	public void setA ( int a) {
//		this.a = a;
//	}
//	public int getA() {
//		return a;
//	}
//}

//	1.4 버전까지 사용하는 방법
/*
class Generic {
		private Object a;
		public Generic ( Object a ) {
			this.a = a;
		}
		public void setA( Object a) {
			this.a = a;
		}
		public Object getA() {
			return a;
		}
}
*/
// 1.5 버전 이후의 제네릭

class Generic <T>{					// T type, E element , K key , V value			// T 는 자료형 자리
	private T a;
	public Generic( T a ) {
		this.a  = a ;
	}
	public void setA(T a) {
		this.a=a;
	}
	public T getA() {
		return a;
	}
}

// Generic
public class GenericEx {
	public static void main(String[] args) {
		Generic <Integer>ge1 = new Generic<Integer>(10);
		Generic <Double>ge2 = new Generic<Double>(10.5);		// 자료형때문에 오류가남...		
		//ge2.setA("ABC");		// String 					 객체 하나에 여러 자료형을 섞어 사용할 수  없다.
		System.out.println("ge1 : " + ge1.getA());
		System.out.println("ge2 : " + ge2.getA());
		
		Generic <String> ge3 = new Generic <String> ("ABC");
		System.out.println("ge3 : " + ge3.getA());
	}
}
