package j05;

// return
public class MethodEx4 {
	// 사용자 정의 함수
	public int hap (int a, int b){
		// 반환되는 자료형을 써준다
		//System.out.println("합 : " + (a+b));
		return a+b;      // 결과형 / 반환형 
	}
	
	public static void main(String[] args) { // main 은 운영체제가 호출한다.
			// new create new object 
			MethodEx4 me = new MethodEx4();  // 객체 생성 (new. instance)  // heap영역의 참조값 me에 대입 (me는 시작주소// . 은 ~ 속에 라는 뜻)
			System.out.println("합 : " + me.hap(5,2)); // 객체.멤버(instance.member) or 참조변수.멤버
	}

}
