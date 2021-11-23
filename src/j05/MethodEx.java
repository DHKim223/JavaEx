package j05;

//Method
//독립된 프로그램
//반복되는 내용을 묶어서 처리
//반드시 호출한 곳으로 되돌아 온다
//인수는 개수에 상관없다
// return 값이 없으면 void
//return 값은 한 개 뿐이다

public class MethodEx {
// method 는 선언 / 구현 / 호출 해야 사용할 수 있다.
	// 멤버함수 / 메소드
	public void sub() {									// 선언 / 구현 
		System.out.println(" Hello Java !!! ");
	}
	
	public static void main(String[] args) {		//main() method
		MethodEx me = new MethodEx();				// 객체생성
		me.sub();														// 객체.메소드  =  호출
		me.sub();
		me.sub();
		
	}

}
