package j07;

// Array �� ���� �ڷ����� ����
// index (0) ���� ����
// ������ �޸�
// �ڹٿ����� �迭�� ��ü��

public class ArrayEx {

	public static void main(String[] args) {
		int m[];										// ��������... �迭 ������ �ƴϴ�.
 		m = new int[] {10, 20, 30};      // �迭 ������ ������ new �� ��ƾ���...... // heap ������ �Ҵ���� �ν��Ͻ�
		
 		int w[] = new int [3];
 		
 		int n[] = {10 , 20 , 30 };		//�ʱⰪ�� �� ��쿡�� new �� �����ص� �ȴ�.... �ι�°�ٰ� ����.
 		

 		System.out.println("m[0] : " + m[0]);
 		System.out.println("m[0] : " + m[1]);
 		System.out.println("m[0] : " + m[2]);
 		
 		System.out.println();
 		for ( int i = 0; i < m.length ; i ++ ) {							// m.length �� �迭�� ������
 			System.out.println("m["+i+"] : " + m[i]);
 		} 
 		System.out.println();
 		
 		// ������ �ݺ��� _ 1.5 ��������
 		for( int a : m ) {								//������ �迭�� ���� �ڷ���. �迭�̳� �÷��Ǹ� �� �� �ִ�.
 			System.out.println( a );
 		}
	}

}
