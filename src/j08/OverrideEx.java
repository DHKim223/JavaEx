package j08;
// �����ε�					��������.... �ϳ��� Ŭ������ ���� �̸��� �޼ҵ尡 ������
// �������̵�					������. ��ӹ��� �ڽ�Ŭ������ �θ�Ŭ���� �޼��带 �ٽ� ����� ���

// Override					�θ� �ִ� �޼ҵ尡 �ڽĿ��� �ִ� ��� ( ��� ���谡 �־�߸� �Ѵ�.)

class OverrideSuper {
	 String name = "�θ�Ŭ����"; 
	public String getName() {								// ���� �޼���
		return name;
	}
}

public class OverrideEx extends OverrideSuper {
	
	String name = "�ڽ�Ŭ����";
	public String getName() {						// �������̵� �޼��� / �θ� �޼��� �������� ���� ���� �����ض�!!!
		return name;
	}
		
	public static void main(String[] args){
		// �θ�Ŭ���� �������� = �θ�Ŭ���� �ν��Ͻ�
		OverrideSuper os = new OverrideSuper();
		System.out.println("�̸� : "  + os.name);
		System.out.println("�̸� : " + os.getName());
		
		// �ڽ�Ŭ���� �������� = �ڽ�Ŭ���� �ν��Ͻ�
		OverrideEx oe = new OverrideEx();
		System.out.println("�̸� : "  + oe.name);
		System.out.println("�̸� : " + oe.getName());
		
		//	�θ�Ŭ���� �������� = �ڽ�Ŭ���� �ν��Ͻ�
		OverrideSuper os1 = new OverrideEx();		// �θ�Ŭ������ �ڽ� Ŭ������ �����Ͽ���.... ���� // �ڵ�����ȯ / ���θ��
		System.out.println("�̸� : "  + os1.name);					//�θ�Ŭ���� __ ���������ʿ� �켱���� �־ �θ�Ŭ����.
		System.out.println("�̸� : " + os1.getName());			//�ڽ�Ŭ����__ �޼��� �������̵�� �ڽ��� �ϳ��� ��Ƴ��´�.
		
		//	�ڽ�Ŭ���� �������� = �θ�Ŭ���� �ν��Ͻ�	// �ڽ�Ŭ������ �θ�Ŭ������ �����Ͽ���... �Ұ���
//		OverrideEx oe1 = (OverrideEx) new OverrideSuper();	// ��������ȯ / ����
//		System.out.println("�̸� : "  + oe1.name);
//		System.out.println("�̸� : " + oe1.getName());
	
		// ������ �̸��� ������ �����͸� �����ؾ� �ϱ⶧���� �θ��� �ڽ��� ���� ��´�.
		// �޼���� �θ����� �޸𸮿� �������� �ʰ� �ڽ��ʸ� ��� ���´�. ... ���� �޼���� ���� ���� �ϱ� �빮��
		// �ڽ�Ŭ����(int) <<< �θ�Ŭ����(double)___�ڽ�Ŭ������ �θ�Ŭ������ ���� �� ������, �ݴ�� �ȵ�
		// ������ ��������ȯ �� �ֵ���.... ������ ��ȯ�ؼ� �θ�Ŭ������ �ڽ�Ŭ������ ������ �� �ִ�.
	
		// API �Ű������� ��Ӱ���
		String str = "Hello Java!!!";
		String s = "!!";
		StringBuffer sb = new StringBuffer ("!!");
		StringBuilder su = new StringBuilder ("!!");
		
		System.out.println("String : " + str.contains(s));					// CharSequence <= String
		System.out.println("StringBuffer : " + str.contains(sb) ); 	// CharSequence <= StringBuffer
		System.out.println("StringBuilder : " + str.contains(su) );	// CharSequence <= StringBuilder
		
		
		
	
		
	}

}
