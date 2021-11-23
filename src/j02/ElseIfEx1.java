package j02;

// 정수를 세 개 입력
// 가장 큰 수 하나만 출력
//
public class ElseIfEx1 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		
		// 조건문 6개
//		if(a>b && a>c)System.out.println(a+"이 최댓값");
//		if(b>a && b>c)System.out.println(b+"이 최댓값");
//		if(c>a && c>b)System.out.println(c+"이 최댓값");

		
		// 조건문 3개
//		if (a>b) 
//			if (a>c) System.out.println(a +" 이 최댓값");
//			else System.out.println(c +" 이 최댓값");
//		else
//			if (b>c) System.out.println(b +" 이 최댓값");
//			else System.out.println(c +" 이 최댓값");
		
		// 효율 극대확
		if(a>b && a>c)System.out.println(a+"이 최댓값");
		else if(b>c)System.out.println(b+"이 최댓값");
		else System.out.println(c+"이 최댓값");
		
	}
}

// else if는 조건을 줄인다!