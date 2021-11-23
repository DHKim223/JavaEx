package j11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		//����
		Vector <String> v = new Vector<String> (5,3) ;
		
		System.out.println("�뷮 : " + v.capacity());
		System.out.println("ũ�� : " + v.size());
		
		//�߰�
		System.out.println("�߰� : " + v.add("ȫ�浿"));
		System.out.println("�߰� : " + v.add("�̼���"));
		System.out.println("�߰� : " + v.add("ȫ�浿"));
		v.addElement("������");
		v.add(2,"������");
		v.insertElementAt("�赵��", 2);

		System.out.println("�뷮 : " + v.capacity());
		System.out.println("ũ�� : " + v.size());
		
		//����
		System.out.println("���� : " + v.remove(0) );
		System.out.println("���� : " + v.remove("������"));
		
		HashSet<String> hs = new HashSet <String>();
		hs.add("������");
		hs.add("�����ҹ�");
		System.out.println("���� : " + v.removeAll(hs));	// �ϳ��� ����� true // �������� �������
		
		System.out.println("�߰� : " +v.addAll(hs));
		
		//���
		for (int i=0; i<v.size(); i++) {
			System.out.println("��� : " + v.elementAt(i));
			System.out.println("��� : " + v.get(i));
		}
		
		//�迭
		String str[] = new String[ v.size()];
		v.copyInto(str);
		for (int i=0; i<str.length; i++) {
			System.out.println("�迭 : " + str[i]);
		}
		
		// Iterator / Enumeration ������ �ݺ���
		// �����ؾ� ����� �� �ִ�.
		Iterator <String > it = v.iterator();
		while( it.hasNext() ) {
			System.out.println( "Iterator : " + it.next() );
		}
		
		Enumeration <String> en = v.elements();
		while (en.hasMoreElements()) {
			System.out.println("Enumeration : " + en.nextElement());
		}

				
		
		//�������̽� ******* ���迡 ���´���
		// 1. implements �� ��ӹ޾Ƽ� ���� �߻�޼��带 ��� ����
		// 2. ��� �����ϰ� �ִ� Ŭ���� extends  �� ��ӹ޾Ƽ� �ʿ��� �޼��常 ������
		// 3. �͸���Ŭ������ �̿��ؼ� �̿ϼ��� �޼��带 �����ؼ� ��ü ����
		// 4. ��� ��ü�� ������ �ִ� �޼��带 ȣ���ؼ� ���Ϲ޾Ƽ� ���
		
		// Ŭ����
		// 1. ��ü����									��ü.���
		// 2. ��ӹ޾Ƽ� �� ����� ��ó�� ���
		// 3. �����ü�� static �� ��� 			Ŭ������.���
		// 4. �ڽ�Ŭ������ ��ü�� ������ ���������� �޾Ƽ� ���
		// 5. Class.forName( class ��� ) ��ü�� �����ؼ� ���
		
		
	}
}
