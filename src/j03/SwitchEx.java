package j03;

public class SwitchEx {
	public static void main ( String[] args) {
		int a = Integer.parseInt(args[2]);
		
		switch( a ) {		// () �ȿ��� ���� / ���� / ������ �������� �� �� �� �� �ִ�.
								// 1.7 ���� �̻󿡼� ���ڿ��� �����ϴ�.
		case 1: System.out.println("�ϳ�");
			break;
		case 2: System.out.println("��");
			break;
		case 3: System.out.println("��");
			break;
		default : System.out.println("����");
		} //���� �� ���� case�� �鿩���� ���� �ʴ´�
		
			
	}	
}
