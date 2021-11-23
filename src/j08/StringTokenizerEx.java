package j08;

import java.util.StringTokenizer;

//	문자열 자르는 클래스
// 디폴트가 없다. ___ 매개변수가 없이 쓰지말라!!!

public class StringTokenizerEx {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("Hello Java!!!","a",true);	// 매개변수를 안주면 false // True를 주면 delimeter 도 토큰화
		System.out.println("Token : " + st.countTokens());	// 토큰 몇개??
		
		while(st.hasMoreTokens()) {
			System.out.println("Token : " + st.nextToken());
		}
		
		System.out.println("Token : " + st.countTokens());	// 위에서 토큰 다 뺏어와서 없다
				
	}
}
