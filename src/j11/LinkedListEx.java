package j11;

//Queue
import java.util.LinkedList;
import java.util.Iterator;
public class LinkedListEx {
	public static void main(String[] args) {
		// ����
		LinkedList <String> ll = new LinkedList <String> ();
		
		// �߰� 
		System.out.println( "�߰� : " + ll.add( "ȫ�浿" ) );
		System.out.println( "�߰� : " + ll.add( "�̼���" ) );
		System.out.println( "�߰� : " + ll.add( "������" ) );
		System.out.println( "�߰� : " + ll.add( "ȫ�浿" ) );
		
		ll.addFirst( "������" );
		ll.offerFirst( "������" );		
		ll.push( "���߱�" );
		
		// ���
		for( int i=0; i<ll.size(); i++ ) {
			System.out.println( "��� : " + ll.get( i ) );
		}
		
		// �ݴ��
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
