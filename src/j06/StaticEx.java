package j06;

// static
// static 영역에 할당된다. ( static / heap /stack )
// 다른 멤버보다 먼저 할당된다.
// 객체없이 점근 가능하다.
// 자동 초기와 된다. 초기화는 한번 만 수행한다.
// 모든 객체들이 사용 할 수 있도록 *공유*개념을 가진다.
// 클래스  변수 / 클래스 메서드라고도 한다.

public class StaticEx {

	private int a = 10;			// 객체 생성시 메모리 할당
	private static int b = 10;	// 프로그램 실행시 메모리 할당 / 프로그램 종료시 메모리 반납
			// 클래스 편수 ( 공유하니까.. ) ( 한번만 할당한다!) (why?? 다른것보다 먼저 할당되니까) 
	public static void main( String[] args ) {
		StaticEx se = new StaticEx();		//static 영역은 객체 생성 전에 메모리를 할당하기 때문에 생성자로 초기화가 안됨.
		// System.out.println( "a : " + a );			// non-static
		System.out.println( "a : " + se.a );
		System.out.println( "b : " + b );				// static
		System.out.println( "b : " + se.b );			// 객체가 있을 경우에는 객체.멤버도 가능
		System.out.println( "b : " + StaticEx.b );    // static 클래스명.멤버 __ static 접근 방법
																			// non-static 객체.멤버
		
		se.a += 10;
		se.b += 10;
		System.out.println( "se a : " + se.a );
		System.out.println( "se b : " + se.b );
		
		StaticEx se1 = new StaticEx(); 	//
		se1.a += 10;
		se1.b += 10; 		// se 를 통해 이미 생성되어 있던 b 에 누적되어 30이 된다.
		System.out.println( "se1 a : " + se1.a );
		System.out.println( "se1 b : " + se1.b );

		
	}

}
