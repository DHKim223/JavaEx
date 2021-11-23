package j11;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;
public class HashtableEx {
	public static void main(String[] args) {
		// ����
		Hashtable <Integer, String> ht = new Hashtable <Integer, String> (/* default �� �Ⱦ���*/);
		
		// �߰� ( map �� index�� ���� �����ϱ� ������ loop�� ����� �ȵ�..)
		ht.put( 100 , "ȫ�浿");
		ht.put( 200 , "�̼���");
		ht.put( 500 , "������");
		System.out.println("ũ�� : " + ht.size());
		
		// ���				( �׷��� �Ʒ��� ���� ������� ����Ѵ�.)
		Enumeration <String> en = ht.elements();
		while ( en.hasMoreElements()) {
			System.out.println("Enumeration : " + en.nextElement());
		}
		
		Enumeration <Integer> e = ht.keys();
		while ( e.hasMoreElements()) {
			System.out.println("Enumeration : " + ht.get(e.nextElement()));
		}
		
		// Collection ȣȯ  ** ���� �������� �迭�� ó������ collection ���� ó���ϴ°� ����.
		Vector<String> v = new Vector <String> (ht.values());
		for(int i=0; i<v.size(); i++) {					// Vector �� get�̶� �޼ҵ带 ���� ȣ���ؾ��Ѵ�.
			System.out.println("Vector : " + v.get(i));
		}
		
	}
}
