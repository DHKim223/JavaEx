package j03;
//숫자 두 개와 연산자 (+ - * / %) 한 개를 입력받는다.
// 입력받은 연산자로 입력받은 숫자를 계산한 후 출력한다.
// 단, 나눗셈은 실수로 출력한다.
// + - * / % 이외에는 "잘못입력" 출력
public class SwtichStudy {

	public static void main(String[] args) throws Exception {
		System.out.print("정수 :  ");
		int a = System.in.read()-48; //0~9
		System.in.read(); //버퍼에 남아있는 enter 제거
		System.in.read();
		
		System.out.print("정수 :  ");
		int b = System.in.read()-48;
		System.in.read();
		System.in.read();
		
		System.out.print("연산자(+ - * / %) : ");
		char c = (char)System.in.read(); // 마지막 입력이라 버퍼제거 안함
		
		//문자로 비교
//		switch(c) {
//		case '+': System.out.println(a +" + "+ b +" = "+(a+b)); break;
//		case '-': System.out.println(a +" - "+ b +" = "+(a-b)); break;
//		case '*': System.out.println(a +" * "+ b +" = "+(a*b)); break;
//		case '/': System.out.println(a + " / " + b + " = "+a/(double)(b)); break;   //(double)(a/b) 는 연산후 double 변환....  연산때 double로 바꿔줘야함. 
//		case '%': System.out.println(a +" % "+ b +" = "+(a%b)); break;
//		default: System.out.println("잘못입력");
		
		//ASCII code
		switch(c) {
		case 43: System.out.println(a + " + " + b + " = " + (a+b)); break;
		case 45: System.out.println(a + " - " + b + " = " + (a-b)); break;
		case 42: System.out.println(a + " * " + b + " = " + (a*b)); break;
		case '/': System.out.println(a + " / " + b + " = " + ((double)a/b)); break;  
		case '%': System.out.println(a + " % " + b + " = " + (a%b)); break;
		default: System.out.println("잘못입력");
		
		}				
		// cal = (double)(a/b);
	}

}
