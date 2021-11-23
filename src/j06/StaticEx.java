package j06;

// static
// static ������ �Ҵ�ȴ�. ( static / heap /stack )
// �ٸ� ������� ���� �Ҵ�ȴ�.
// ��ü���� ���� �����ϴ�.
// �ڵ� �ʱ�� �ȴ�. �ʱ�ȭ�� �ѹ� �� �����Ѵ�.
// ��� ��ü���� ��� �� �� �ֵ��� *����*������ ������.
// Ŭ����  ���� / Ŭ���� �޼����� �Ѵ�.

public class StaticEx {

	private int a = 10;			// ��ü ������ �޸� �Ҵ�
	private static int b = 10;	// ���α׷� ����� �޸� �Ҵ� / ���α׷� ����� �޸� �ݳ�
			// Ŭ���� ��� ( �����ϴϱ�.. ) ( �ѹ��� �Ҵ��Ѵ�!) (why?? �ٸ��ͺ��� ���� �Ҵ�Ǵϱ�) 
	public static void main( String[] args ) {
		StaticEx se = new StaticEx();		//static ������ ��ü ���� ���� �޸𸮸� �Ҵ��ϱ� ������ �����ڷ� �ʱ�ȭ�� �ȵ�.
		// System.out.println( "a : " + a );			// non-static
		System.out.println( "a : " + se.a );
		System.out.println( "b : " + b );				// static
		System.out.println( "b : " + se.b );			// ��ü�� ���� ��쿡�� ��ü.����� ����
		System.out.println( "b : " + StaticEx.b );    // static Ŭ������.��� __ static ���� ���
																			// non-static ��ü.���
		
		se.a += 10;
		se.b += 10;
		System.out.println( "se a : " + se.a );
		System.out.println( "se b : " + se.b );
		
		StaticEx se1 = new StaticEx(); 	//
		se1.a += 10;
		se1.b += 10; 		// se �� ���� �̹� �����Ǿ� �ִ� b �� �����Ǿ� 30�� �ȴ�.
		System.out.println( "se1 a : " + se1.a );
		System.out.println( "se1 b : " + se1.b );

		
	}

}
