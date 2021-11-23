package j03;

public class SwitchEx {
	public static void main ( String[] args) {
		int a = Integer.parseInt(args[2]);
		
		switch( a ) {		// () 안에는 정수 / 문자 / 정수로 떨어지는 식 만 올 수 있다.
								// 1.7 버전 이상에서 문자열도 가능하다.
		case 1: System.out.println("하나");
			break;
		case 2: System.out.println("둘");
			break;
		case 3: System.out.println("셋");
			break;
		default : System.out.println("숫자");
		} //눈에 잘 띄라고 case는 들여쓰기 하지 않는다
		
			
	}	
}
