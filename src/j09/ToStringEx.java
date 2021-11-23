package j09;
//다형성 활용

import java.util.Date;
import java.util.Random;

public class ToStringEx {		//extends Object가 생략되어 있다!!!!
	
	public String toString() {
		return "toString 재정의";
	}
	
	public static void main(String[] args) {
		ToStringEx ts = new ToStringEx();		
		System.out.println("ts : " + ts);		// Object의 toString()호출							/	/32비트 주소
		System.out.println("ts : " + ts.toString());
		
		Date date = new Date();
		System.out.println("date : " + date);					// Data의 toString() 호출
		System.out.println("date : " + date.toString());
		
		String str = new String("대한민국");				
		System.out.println("str : " + str);								//String의 toString()호출
		System.out.println("str : " + str.toString());
		
		Random random = new Random();				
		System.out.println("random : " + random );					//주소
		System.out.println("random : " + random.toString() );
		
		//  toString을 재정의 해놓은 애들은 자기들꺼 실행되고
		//  재정의를 안한애들은 object의 toString이 실행된다.

	}
}
