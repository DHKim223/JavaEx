package j02;

//점수 입력
//점수 90점 이상이면 "A학점" 출력
//점수 80점 이상이면 "B학점" 출력
//점수 70점 이상이면 "C학점" 출력
//점수 60점 이상이면 "D학점" 출력
//점수 60점 미만이면 "F학점" 출력

public class ElseIfEx {
	public static void main(String[] args) {
		
		int a = Integer.parseInt(args[0]); // 98 85 75 65 55 105 -50
		
//		if( a>=90) System.out.println("A학점");
//		if( a>=80) System.out.println("B학점");
//		if( a>=70) System.out.println("C학점");
//		if( a>=60) System.out.println("D학점");
//		if( a< 60) System.out.println("F학점");

		// 범위	// 가독성을 위해 변수는 왼쪽에
		// a >= 0 && a <= 100
		
		// 이런 코딩은 불필요한 작업을 계속한다.
//		if(a >= 90 && a <= 100) System.out.println("A학점");
//		if(a >= 80 && a < 90) System.out.println("B학점");
//		if(a >= 70 && a < 80) System.out.println("C학점");
//		if(a >= 60 && a < 70) System.out.println("D학점");
//		if(a >= 0  && a < 60) System.out.println("F학점");
	
		if(a >= 90) System.out.println("A학점");
		else if(a >= 80) System.out.println("B학점");
		else if(a >= 70) System.out.println("C학점");
		else if(a >= 60) System.out.println("D학점");
		else System.out.println("F학점");
		
	}
}
