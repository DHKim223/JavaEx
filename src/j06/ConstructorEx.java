package j06;

// ������ Constructor				�Ҹ��� ( �޸� ���� �Լ� ) Destructor �� ����
// �����ڴ� Method
// Ŭ������� �����ϴ�.
//����� ��ȯ���� ����.				// void �� ������ ������ ���ϰ��� ����.
// �������� ������ default �� ����ȴ�.		// �����ϸ� default  �� �������
// ��ü ������ �ڵ� ȣ��ȴ�.
// ��ü �ʱ�ȭ�� ���ȴ�


public class ConstructorEx {
	
	private String name;
	private int age;
		
	public void setName ( String n) {
		name = n;
	}

	public void setAge(int a ) {
		age = a;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public ConstructorEx() {								// Ŭ���� ��� ����. ��ȯ�� ����.
		System.out.println("default ������");		// ��ü �ʱ�ȭ �޼���
	}

	public ConstructorEx ( String n,  int a ) {
		System.out.println("������");
		name = n;
		age = a;
	}
	
	public static void main(String[] args) {
		
		ConstructorEx ce = new ConstructorEx(); // ***������ ȣ��...*** ( default) -- ��ü �ʱ�ȭ     // ��ü�� ����ڿ��� �����Ⱚ�� ����־
		
		//ce.setName("ȫ�浿");															// setter �� ���� initialize 
		
		//ce.setAge( 30);				// ������ �Ź� setter�� ���� initialize �ϸ� ������ ... �׷��� �����ڸ� ���� _�ڵ�ȣ��_��ü�ʱ�ȭ �� �Ѵ�.
		System.out.println("�̸� : " + ce.getName());
		System.out.println("���� : " + ce.getAge());
				
		
		ConstructorEx ce1 = new ConstructorEx("�̼���",20);  // default ������ ȣ���� �ƴϰ� �ʿ���� but ������ �����ε� �ʿ�
		System.out.println(ce1.getName());
		System.out.println(ce1.getAge());
	}

}


// �����ڴ� ȣ���Ҷ� ��ü�ʱ�ȭ!!