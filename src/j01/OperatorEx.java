package j01;

/*
	1. 증감 연산자
		++ --
	2. 산술 연산자
		* / % + -
	*3. 쉬프트 연산자
		<< >> >>>
	4. 비교 연산자
		< > <= >= == !=
	*5. 비트 연산자
		& | ^ ~				~ ( 1의 보수연산자 / bit not) 는 1번
	6. 논리 연산자
		&& || ! 			! (부정연산자 / 논리 not) 는 1번
	*7. 조건(삼향)연산자
		? :
	8. 대입연산자
		= += -+ *= /= %=		
 */


public class OperatorEx {
	public static void main(String[] args) {
		//증감연산자
		int a = 10, b=10;
		System.out.println("a :" + a  + "\t" + "b : " + b);
		
		//선증가  b=++a; -> a,b = 11  / b=a++; a=10 b=11
		b = ++a;
		System.out.println("a :" + a  + "\t" + "b : " + b);
		
		b = a++;	//후증가  
		// b= ++a ; a를 1 증가시키고 b에 대입.  // b=a++; a를 b에 대입한 뒤 1증가
		System.out.println("a :" + a  + "\t" + "b : " + b);
		
		//산술연산자
		System.out.println(5/2);
		System.out.println(5/2.0);
		System.out.println(5/(double)2);
		System.out.println(5/2f); //실수우선
		System.out.println('A'+1); // 문자 2byte + 정수 4byte
		System.out.println('A'+'1'); // 실수 over 문자
		System.out.println('A'+"1");
		
		int c=20;
		System.out.println(c>>2); //오른쪽으로 두번 20 = 10100  20>>2 = 101  >> 는 %2와 같다.... 소수점버림 
		System.out.println(c<<2); //왼쪽이동 = *2와 같다
		System.out.println(c>>>2);
		
		//비트 논리연산자            = 는 대입연산자.  오른쪽을 왼쪽에 대입
		
		a=20;
		b=12;
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b);
		
		//논리연산자
		boolean t = true;
		boolean f = false;
		System.out.println(t && t);
		System.out.println(f && f);
		System.out.println(f && t);
		System.out.println(t && f);
		
		System.out.println(t || t);
		System.out.println(f || f);
		System.out.println(f || t);
		System.out.println(t || f);
		
		int d= 8;
		System.out.println(~d+1); //0이 양수에 포함됨. a 는 -(a+1) 이 된다.
		
		System.out.println(5 != 6);
		System.out.println(5 != 5);
		
		System.out.println(!(5>3));
		
		//대입연산자
		// = 는 단순 대입 연산자
		// +=   -=   *=    /=    %=  산술 대입연산자
		
		int e = 5;
		System.out.println(e += 2);  // 1 이외의 것 증감...
		}
}
