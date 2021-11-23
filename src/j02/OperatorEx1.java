package j02;

// 명령줄 인수
// 대입한 arguments가 args[] 에 들어감 
public class OperatorEx1 {
	public static void main( String[] args) {
		// Integer.parseInt 는 문자를 정수로 바꿔주는 함수
		int a = Integer.parseInt(args[2]); // 배열안에 들어간 애들은 문자열임.... 숫자가 아니다
		
		// (조건) 4를 2로 나누었을때 나머지가 0이냐? True 면 Even, False면 Odd
		System.out.println(a % 2 == 0 ? "Even" : "Odd");
		System.out.println(a % 2 != 0 ? "Odd" : "Even");
		
		
	}
}
