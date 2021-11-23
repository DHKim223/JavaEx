package j05;

// 매개변수 인수 인자 argument parameter       같은말
// 합 차 곱 몫 을 구하는 함수 구현
public class MethodEx2 {
	//int a =5, b=2;	// 전역변수 / 멤버변수( class 안에 있는 변수 .... 자바의 전역변수는 엄밀히 전역변수가 아님) 
	
	public void hap(int a, int b) {			// 매개변수 .. 또한 지역변수
		//int a =5, b=2;												//지역변수
		System.out.println("합 : " + (a+b));
	}
	
	public void cha(int a, int b) {
		System.out.println("차 : " + (a-b));
	}
	
	public void gop(int a, int b) {
		System.out.println("곱 : " + (a*b));
	}
	
	public void mok(int a, int b) {
		System.out.println("몫 : " + ((double)a/b));
	}
	public static void main(String[] args) {
		MethodEx2 me = new MethodEx2();
		me.hap(5, 2 );
		me.cha( 4, 3);
		me.gop( 7, 3);
		me.mok( 7,3);
				
	}

}
