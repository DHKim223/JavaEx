package j03;

// ���� �ϳ� �Է�
// 2~9 ���̸� ������ ���
// 2~9 ���̰� �ƴϸ� �ٽ� �Է�(�ݺ���)

//System.in.read()  -- ���� �ϳ��� �Է¹��� -- ���ڷ� ����(ASCII �ڵ尪)
// 
 

public class DoWhileEx1 {

	public static void main(String[] args) throws Exception{
		
		int dan =0;
		do {
			System.out.println("����(2~9) : ");
			dan = System.in.read()-48;
			System.in.read(); // ���͸� ��ư��� , ������ �Էµ� ���� ���� �ʴ´�
			System.in.read(); // ���ۿ� �����ִ� Enter�� ���ֶ�.... 
		}while (dan<2 || dan >9);     // 2~9���� �ƴϸ� do �� ���ư��� �ٽý���!
			
			for(int i =1; i<10; i++) {                 // �ùٸ� dan ���� �޾����� ����ȴ�.
				System.out.println(dan+"*"+i +"="+dan*i);
			}
	}
//Ű���� ���� (�ӽ� ������)
// read �� ���ۿ� �ִ� ���� �д´�. 
// 2��� ���� ������
// ���ۿ� �ִ� ������(����)�� �������Ҷ��� �ִ�.

}
