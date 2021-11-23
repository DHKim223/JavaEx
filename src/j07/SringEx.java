package j07;

// String Class
public class SringEx {

	public static void main(String[] args) {
		String s1 = "Hello";								// 문자열 - 포인터로 관리 / 자바에서 String 으로 관리
		String s2 = "Hello";								// 자바에서는 문자열은 String 클래스 객체
		
		if ( s1 == s2) System.out.println("같다");								// 같다		(주소비교)
		else System.out.println("다르다");
	
		if ( s1.equals(s2)) System.out.println("같다");						// 같다		(값을비교)
		else System.out.println("다르다");
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
		if ( s3 == s4) System.out.println("같다");								// 다르다	
		else System.out.println("다르다");
	
		if ( s3.equals(s4)) System.out.println("같다");						// 같다
		else System.out.println("다르다");	
		
		System.out.println();
		
		s1 +=  " Java!!!";
		if ( s1 == s2) System.out.println("같다");								// 다르다		(주소비교)
		else System.out.println("다르다");

		
		// String Class 로 문자열 관리를 할 때는 길이를 변화시키면 안된다. ____ Garbage가 생긴다.
		// 문자의 길이를 바꿀때는 StringBuffer 클래스를 사용____ 여유 공간을 갖는다.
		
		// Method Practice
		System.out.println();
		System.out.println("s1 : " + s1);
		
		System.out.println("charAt : " + s1.charAt(6));
		System.out.println("concat : " + s1.concat("!!"));
		System.out.println("s1 : " + s1);									// StringBuffer 는 원본이 바뀐다.
		System.out.println("endsWith : " + s1.endsWith("!!")); // True
		System.out.println("endsWith : " + s1.endsWith("!!!!")); // False
		System.out.println("startsWith : " + s1.startsWith("Hello"));// True
		System.out.println("startsWith : " + s1.startsWith("hello"));// False
		if("ABC".equals("abc"))System.out.println("같다");
		else System.out.println("다르다");
		System.out.println("hashCode : " + s1.hashCode());  // int로 찍은 주소
		System.out.println("indexOf : " + s1.indexOf('a'));
		System.out.println("lastIndexOf : " + s1.lastIndexOf('a'));
		System.out.println("indexOf : " + s1.indexOf('A'));			//-1 => 없다
		System.out.println("isEmpty : " + s1.isEmpty()); // 비어있으면 True.. 데이터가 있으면 False
		
		System.out.println("length : " + s1.length()); // null 제외 나머지 길이
		System.out.println("replace : " +s1.replace('a', 'o'));
		
		System.out.println("split : " + s1.split("a"));	//delimiter __ 구분자   // String 이라 for문으로 받아
		
		String s[] = s1.split("a");
		for ( String a: s) {
			System.out.print( a + "\t");
		}System.out.println();
		
		System.out.println("subString : " + s1.substring(6));				// Java!!!
		System.out.println("subString : " + s1.substring(6,12));			// Java!! (null) 주의 			endIndex  - 1
		System.out.println("toUpperCase : " + s1.toUpperCase());
		System.out.println("toLowerCase : " + s1.toLowerCase());

		String ss = "       a        a        a        ";
		System.out.println("trim : " + ss);					// 띄어쓰기도 데이터
		System.out.println("trim : " + ss.trim());			// 앞뒤로 필요없는 띄어스기 trim!
	}
}
