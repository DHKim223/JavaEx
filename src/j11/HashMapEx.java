package j11;

//Map			HashMap
//HashTable

//Ű�� ���� ����. Key / Value �ڷ����� ���� ����
//Key / Value �� ���� �����ͷ� ��� ó��
//�ݺ����� Ȱ���� �� ����. 

import java.util.HashMap;
public class HashMapEx {
	public static void main(String[] args) {
		// ����
		HashMap <Integer, String> hm = new HashMap <Integer, String> ();
		
		// �߰�
		hm.put( 7, "ȫ�浿" );
		hm.put( 3, "������" );
		hm.put( 0, "�̼���" );
		hm.put( 9, "������" );
		
		System.out.println( "ũ�� : " + hm.size() );
		
		// ���
		for( String s : hm.values() ) {						// V ���� Collection 
			System.out.println( "��� : " + s );
		}
		
		for( Integer i : hm.keySet() ) {					// K Ű�� Set
			System.out.println( "��� : " + hm.get( i ) );
		}
		
		System.out.println( "��� : " + hm );

	}
}
