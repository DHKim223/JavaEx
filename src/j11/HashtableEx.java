package j11;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;
public class HashtableEx {
	public static void main(String[] args) {
		// 생성
		Hashtable <Integer, String> ht = new Hashtable <Integer, String> (/* default 라 안쓴다*/);
		
		// 추가 ( map 은 index를 직접 관리하기 때문에 loop로 출력이 안됨..)
		ht.put( 100 , "홍길동");
		ht.put( 200 , "이순신");
		ht.put( 500 , "김유신");
		System.out.println("크기 : " + ht.size());
		
		// 출력				( 그래서 아래와 같은 방법으로 출력한다.)
		Enumeration <String> en = ht.elements();
		while ( en.hasMoreElements()) {
			System.out.println("Enumeration : " + en.nextElement());
		}
		
		Enumeration <Integer> e = ht.keys();
		while ( e.hasMoreElements()) {
			System.out.println("Enumeration : " + ht.get(e.nextElement()));
		}
		
		// Collection 호환  ** 계산기 문제에서 배열로 처리보단 collection 으로 처리하는게 쉽다.
		Vector<String> v = new Vector <String> (ht.values());
		for(int i=0; i<v.size(); i++) {					// Vector 는 get이란 메소드를 통해 호출해야한다.
			System.out.println("Vector : " + v.get(i));
		}
		
	}
}
