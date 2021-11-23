package j10;

// �ڷ����� �������� �ʰ� ���___ �ڷ����� �̸� ������ �ʰ� ���.

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

//	1.4 �������� ����ϴ� ���
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
// 1.5 ���� ������ ���׸�

class Generic <T>{					// T type, E element , K key , V value			// T �� �ڷ��� �ڸ�
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
		Generic <Double>ge2 = new Generic<Double>(10.5);		// �ڷ��������� ��������...		
		//ge2.setA("ABC");		// String 					 ��ü �ϳ��� ���� �ڷ����� ���� ����� ��  ����.
		System.out.println("ge1 : " + ge1.getA());
		System.out.println("ge2 : " + ge2.getA());
		
		Generic <String> ge3 = new Generic <String> ("ABC");
		System.out.println("ge3 : " + ge3.getA());
	}
}
