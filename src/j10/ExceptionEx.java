package j10;

// Java �� ��� ����___ ����ó�� ����

// ������ �ȳ��� ���� // java.lang.RuntimeException �� ��ӹ��� �ֵ�.....
// ����ó��				try~catch ��´� / throws ������.
public class ExceptionEx {
	public static void main(String[] args) {
		int m[] = { 10 , 20 , 30};
		
		try {
			for ( int i=0; i<m.length + 1; i++) {
				System.out.println(i + "\t" + m[i]);
			}	
			System.out.println("���α׷� ��");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� ������ �Ѿ���.");
			e.printStackTrace();
		} finally {
			// ���ܰ� �ְ� ���� ������ �����ϴ� ���
			System.out.println("���α׷��� ");
		}
		
	
	}
}
