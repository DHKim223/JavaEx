package j11;

import java.util.Stack;

// Stack		LIFO
public class StackEx {
	public static void main(String[] args) {
		//����
		Stack<String> s = new Stack<String>();
		
		//�߰�
		System.out.println("�߰� : " + s.push("ȫ�浿"));
		System.out.println("�߰� : " + s.push("�̼���"));
		System.out.println("�߰� : " + s.push("������"));
		
		//���
		while( !s.empty() ) {
			//System.out.println("���:  " + s.peek() );		// ������ �ʾƼ� ���ѷ���
			System.out.println("���:  " + s.pop() );		// ������ ����
		}

	}
}
