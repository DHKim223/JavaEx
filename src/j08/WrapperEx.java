package j08;
// Data Type					Wrapper Class

//변수 								객체__Method 사용가능!! ex Integer.parseInt("123")

// boolean						Boolean
//	byte								Byte
//	short							Short
//	int								Integer
// long								Long
//	float								Float
// double							Double
// char								Character
//	void								Void

// Wrapper Class 는 method를 사용 할 수 있다.
//	기본자료형을 사용하면 에러가 나고 Wrapper Class 를 사용해야 하는 경우가 있음...

public class WrapperEx {

	public static void main(String[] args) {
		// integer는 Default 없음
		
		int a = 10;
		Integer b= new Integer(10); // Deprecated 라서 줄감.

		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		System.out.println(Integer.parseInt("123"));
		System.out.println( Integer.toBinaryString(20));		//2진수
		System.out.println( Integer.toHexString(15));			//16진수 ____ 2진수를 4칸씩 끊음 
		System.out.println( Integer.toOctalString(20));		//8진수	 ____ 2진수를 3칸씩 끊음
		
		System.out.println(Integer.BYTES );
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		// 오토박싱 // 언박싱							jdk 1.5버전 이후 - 일반자료형 Wrapper 클래스 호환 가능
		int c = new Integer(10);					//정수 room 에 주소 넣음....
		Integer d = 20;									//주소 room 에 정수 넣음....
		
		// 원래는 Integer e = new Integer(10);
		//				int e = 10;
		System.out.println("c : " + c);
		System.out.println("d : " + d);
	}
}
