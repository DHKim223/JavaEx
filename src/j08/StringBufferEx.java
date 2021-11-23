package j08;

//	Stirng 									문자열의 길이가 변하면 Garbage가 발생.
//	StringBuffer							문자열의 길이가 변하면 여유 공간에 추가한다.
//	String 과 StirngBuffer 는 호환이 된다.
public class StringBufferEx {

	public static void main(String[] args) {
		//디폴트 생성자를 쓰고 싶을때 api확인해 class 안에 디폴트 생성사가 있어야 한다.
		
		// 객체 생성
		StringBuffer sb = new StringBuffer("Hello Java!!!");	//문자열 받는 생성자가 있어야 이런식으로 사용가능
		System.out.println("용량 : " + sb.capacity()); 	// 빈공간 포함
		System.out.println("길이 : " + sb.length());		//빈공간 제외 길이
		
		// 추가
		System.out.println("추가 : " + sb.append("!!"));
		System.out.println("추가 : " + sb);
		System.out.println("추가 : " + sb.insert(5 , " Python & "));
			
		System.out.println("용량 : " + sb.capacity()); 	// 용량은 그대로
		System.out.println("길이 : " + sb.length());		// 길이만 증가
		System.out.println("반대 : " + sb.reverse());
		
		// 삭제
		System.out.println("삭제 : " + sb.delete(5,sb.length()));
		System.out.println("길이 : " + sb.length());		
		System.out.println("반대 : " + sb.reverse());
		
		// Trim
		sb.trimToSize(); 	// 리턴값이 없으면 출력하지 못한다.	// 작업 완료후 trim으로 용량 줄인다.
		System.out.println("용량 : " + sb.capacity());
		System.out.println("길이 : " + sb.length());
	}
}
