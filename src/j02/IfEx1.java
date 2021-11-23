package j02;

// 정수하나 입력
// 2와 3의 공배수면 "공배수 출력
// 아니면 "아니다 출력"

public class IfEx1 {
	public static void main(String args[])
	//public static void main(String[] args) 
											{
		
		int a = Integer.parseInt(args[0]); // 6 10 12
		if (a % 2 == 0 && a % 3 == 0) {
			System.out.println("공배수");
		} else {
			System.out.println("공배수 아니다");
		}
				
	}
}

