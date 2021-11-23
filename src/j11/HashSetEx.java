package j11;
/*

 
Collection			Set				HashSet
												TreeSet
							List				Vector					Stack
												ArrayList
							Queue			LinkedList				
							
 �迭�� �������� �޸� �Ҵ� ( ����, ������ �Ұ���)
 
 �ҿ������� �޸� ������ ����ȭ �����ش�.
 ���� ������ �����ϴ�.
 
 Set					�ε��� ����. ������ �ȵȴ�. �ߺ��� �ȵȴ�. �ݺ��� ���� �� ����.
 						�뷮�� ������ �����ϸ� �ӵ��� ������.
 
 List					�ε����� �־ �ߺ��� �����ϴ�. �迭�� ��� . �뷮�� �����͵� �ӵ�����
 
 
Map						HashMap
							HashTable
 */
import java.util.HashSet;
public class HashSetEx {
	public static void main(String[] args) {
		//����
		HashSet <String> hs = new HashSet <String>();
		
		//�߰�
		System.out.println(" �߰� : "+hs.add("ȫ�浿"));
		System.out.println(" �߰� : "+hs.add("�赵��"));
		System.out.println(" �߰� : "+hs.add("�̼���"));
		System.out.println(" �߰� : "+hs.add("ȫ�浿")); // �ߺ��̶� add �Ұ�
		
		//�˻�
		System.out.println("�˻� : " + hs.contains("�赵��"));
		
		//����
		System.out.println("���� : " + hs.remove("�赵��"));

		System.out.println("ũ�� : " + hs.size());
		
		//���	- 	������ ����
		for (String s: hs) {						// �迭�̳� �÷���
			System.out.println(s);
		}
		
		
		
	}
}
