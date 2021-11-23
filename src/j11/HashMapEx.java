package j11;

//Map			HashMap
//HashTable

//키도 직접 관리. Key / Value 자료형도 직접 관리
//Key / Value 한 쌍의 데이터로 묶어서 처리
//반복문을 활용할 수 없다. 

import java.util.HashMap;
public class HashMapEx {
	public static void main(String[] args) {
		// 생성
		HashMap <Integer, String> hm = new HashMap <Integer, String> ();
		
		// 추가
		hm.put( 7, "홍길동" );
		hm.put( 3, "김유신" );
		hm.put( 0, "이순신" );
		hm.put( 9, "강감찬" );
		
		System.out.println( "크기 : " + hm.size() );
		
		// 출력
		for( String s : hm.values() ) {						// V 값을 Collection 
			System.out.println( "출력 : " + s );
		}
		
		for( Integer i : hm.keySet() ) {					// K 키를 Set
			System.out.println( "출력 : " + hm.get( i ) );
		}
		
		System.out.println( "출력 : " + hm );

	}
}
