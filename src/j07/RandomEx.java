package j07;

//import java.lang.Math; // lang package 는 따로 import 하지 않아도 됨.
public class RandomEx {

	public static void main(String[] args) {
//		Math m = new Math();					// private 이라 사용할 수 없다. ---- 객체 생성해서 사용하지 말것
		
		// 클래스 사용법
		// 1. 객체 생성 or 상속
		// 2. 멤버가 모두 static
		for (int i = 0 ; i<6 ; i++) {
		//System.out.println( (int) (Math.random( )*100) +1   ); // class.함수()         // 0.0~1.0
		System.out.println( (int) (Math.random( )*45) +1   );   // 1~45 
		}
		
	}	
}
