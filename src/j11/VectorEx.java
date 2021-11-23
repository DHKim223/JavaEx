package j11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		//생성
		Vector <String> v = new Vector<String> (5,3) ;
		
		System.out.println("용량 : " + v.capacity());
		System.out.println("크기 : " + v.size());
		
		//추가
		System.out.println("추가 : " + v.add("홍길동"));
		System.out.println("추가 : " + v.add("이순신"));
		System.out.println("추가 : " + v.add("홍길동"));
		v.addElement("김유신");
		v.add(2,"강감찬");
		v.insertElementAt("김도헌", 2);

		System.out.println("용량 : " + v.capacity());
		System.out.println("크기 : " + v.size());
		
		//삭제
		System.out.println("삭제 : " + v.remove(0) );
		System.out.println("삭제 : " + v.remove("김유신"));
		
		HashSet<String> hs = new HashSet <String>();
		hs.add("강감찬");
		hs.add("연개소문");
		System.out.println("삭제 : " + v.removeAll(hs));	// 하나라도 지우면 true // 강감찬만 지운상태
		
		System.out.println("추가 : " +v.addAll(hs));
		
		//출력
		for (int i=0; i<v.size(); i++) {
			System.out.println("출력 : " + v.elementAt(i));
			System.out.println("출력 : " + v.get(i));
		}
		
		//배열
		String str[] = new String[ v.size()];
		v.copyInto(str);
		for (int i=0; i<str.length; i++) {
			System.out.println("배열 : " + str[i]);
		}
		
		// Iterator / Enumeration 열거자 반복자
		// 지원해야 사용할 수 있다.
		Iterator <String > it = v.iterator();
		while( it.hasNext() ) {
			System.out.println( "Iterator : " + it.next() );
		}
		
		Enumeration <String> en = v.elements();
		while (en.hasMoreElements()) {
			System.out.println("Enumeration : " + en.nextElement());
		}

				
		
		//인터페이스 ******* 시험에 나온다잇
		// 1. implements 로 상속받아서 직접 추상메서드를 모두 구현
		// 2. 대신 구현하고 있는 클래스 extends  로 상속받아서 필요한 메서드만 재정의
		// 3. 익명내부클래스를 이용해서 미완성된 메서드를 구현해서 객체 생성
		// 4. 대신 객체를 생성해 주는 메서드를 호출해서 리턴받아서 사용
		
		// 클래스
		// 1. 객체생성									객체.멤버
		// 2. 상속받아서 내 멤버인 것처럼 사용
		// 3. 멤버전체가 static 인 경우 			클래스명.멤버
		// 4. 자식클래스로 객체를 생성해 참조변수로 받아서 사용
		// 5. Class.forName( class 경로 ) 객체를 생성해서 사용
		
		
	}
}
