package j08;

//	Stirng 									���ڿ��� ���̰� ���ϸ� Garbage�� �߻�.
//	StringBuffer							���ڿ��� ���̰� ���ϸ� ���� ������ �߰��Ѵ�.
//	String �� StirngBuffer �� ȣȯ�� �ȴ�.
public class StringBufferEx {

	public static void main(String[] args) {
		//����Ʈ �����ڸ� ���� ������ apiȮ���� class �ȿ� ����Ʈ �����簡 �־�� �Ѵ�.
		
		// ��ü ����
		StringBuffer sb = new StringBuffer("Hello Java!!!");	//���ڿ� �޴� �����ڰ� �־�� �̷������� ��밡��
		System.out.println("�뷮 : " + sb.capacity()); 	// ����� ����
		System.out.println("���� : " + sb.length());		//����� ���� ����
		
		// �߰�
		System.out.println("�߰� : " + sb.append("!!"));
		System.out.println("�߰� : " + sb);
		System.out.println("�߰� : " + sb.insert(5 , " Python & "));
			
		System.out.println("�뷮 : " + sb.capacity()); 	// �뷮�� �״��
		System.out.println("���� : " + sb.length());		// ���̸� ����
		System.out.println("�ݴ� : " + sb.reverse());
		
		// ����
		System.out.println("���� : " + sb.delete(5,sb.length()));
		System.out.println("���� : " + sb.length());		
		System.out.println("�ݴ� : " + sb.reverse());
		
		// Trim
		sb.trimToSize(); 	// ���ϰ��� ������ ������� ���Ѵ�.	// �۾� �Ϸ��� trim���� �뷮 ���δ�.
		System.out.println("�뷮 : " + sb.capacity());
		System.out.println("���� : " + sb.length());
	}
}
