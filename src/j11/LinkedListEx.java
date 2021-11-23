package j11;

//Queue
import java.util.LinkedList;
import java.util.Iterator;
public class LinkedListEx {
	public static void main(String[] args) {
		// 생성
		LinkedList <String> ll = new LinkedList <String> ();
		
		// 추가 
		System.out.println( "추가 : " + ll.add( "홍길동" ) );
		System.out.println( "추가 : " + ll.add( "이순신" ) );
		System.out.println( "추가 : " + ll.add( "김유신" ) );
		System.out.println( "추가 : " + ll.add( "홍길동" ) );
		
		ll.addFirst( "대조영" );
		ll.offerFirst( "강감찬" );		
		ll.push( "안중근" );
		
		// 출력
		for( int i=0; i<ll.size(); i++ ) {
			System.out.println( "출력 : " + ll.get( i ) );
		}
		
		// 반대로
		Iterator <String> it = ll.descendingIterator();
		while( it.hasNext() ) {
			System.out.println( "Iterator : " + it.next() );
		}
		
		while( ll.size() > 0 ) {
			// System.out.println( "pop : " + ll.pop() );
			System.out.println( "poll : " + ll.poll() );
		}
		
	}
}
