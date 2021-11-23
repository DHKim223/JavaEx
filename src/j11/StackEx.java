package j11;

import java.util.Stack;

// Stack		LIFO
public class StackEx {
	public static void main(String[] args) {
		//생성
		Stack<String> s = new Stack<String>();
		
		//추가
		System.out.println("추가 : " + s.push("홍길동"));
		System.out.println("추가 : " + s.push("이순신"));
		System.out.println("추가 : " + s.push("김유신"));
		
		//출력
		while( !s.empty() ) {
			//System.out.println("출력:  " + s.peek() );		// 지우지 않아서 무한루프
			System.out.println("출력:  " + s.pop() );		// 꺼내고 지움
		}

	}
}
