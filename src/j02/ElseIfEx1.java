package j02;

// ������ �� �� �Է�
// ���� ū �� �ϳ��� ���
//
public class ElseIfEx1 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		
		// ���ǹ� 6��
//		if(a>b && a>c)System.out.println(a+"�� �ִ�");
//		if(b>a && b>c)System.out.println(b+"�� �ִ�");
//		if(c>a && c>b)System.out.println(c+"�� �ִ�");

		
		// ���ǹ� 3��
//		if (a>b) 
//			if (a>c) System.out.println(a +" �� �ִ�");
//			else System.out.println(c +" �� �ִ�");
//		else
//			if (b>c) System.out.println(b +" �� �ִ�");
//			else System.out.println(c +" �� �ִ�");
		
		// ȿ�� �ش�Ȯ
		if(a>b && a>c)System.out.println(a+"�� �ִ�");
		else if(b>c)System.out.println(b+"�� �ִ�");
		else System.out.println(c+"�� �ִ�");
		
	}
}

// else if�� ������ ���δ�!