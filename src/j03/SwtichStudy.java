package j03;
//���� �� ���� ������ (+ - * / %) �� ���� �Է¹޴´�.
// �Է¹��� �����ڷ� �Է¹��� ���ڸ� ����� �� ����Ѵ�.
// ��, �������� �Ǽ��� ����Ѵ�.
// + - * / % �̿ܿ��� "�߸��Է�" ���
public class SwtichStudy {

	public static void main(String[] args) throws Exception {
		System.out.print("���� :  ");
		int a = System.in.read()-48; //0~9
		System.in.read(); //���ۿ� �����ִ� enter ����
		System.in.read();
		
		System.out.print("���� :  ");
		int b = System.in.read()-48;
		System.in.read();
		System.in.read();
		
		System.out.print("������(+ - * / %) : ");
		char c = (char)System.in.read(); // ������ �Է��̶� �������� ����
		
		//���ڷ� ��
//		switch(c) {
//		case '+': System.out.println(a +" + "+ b +" = "+(a+b)); break;
//		case '-': System.out.println(a +" - "+ b +" = "+(a-b)); break;
//		case '*': System.out.println(a +" * "+ b +" = "+(a*b)); break;
//		case '/': System.out.println(a + " / " + b + " = "+a/(double)(b)); break;   //(double)(a/b) �� ������ double ��ȯ....  ���궧 double�� �ٲ������. 
//		case '%': System.out.println(a +" % "+ b +" = "+(a%b)); break;
//		default: System.out.println("�߸��Է�");
		
		//ASCII code
		switch(c) {
		case 43: System.out.println(a + " + " + b + " = " + (a+b)); break;
		case 45: System.out.println(a + " - " + b + " = " + (a-b)); break;
		case 42: System.out.println(a + " * " + b + " = " + (a*b)); break;
		case '/': System.out.println(a + " / " + b + " = " + ((double)a/b)); break;  
		case '%': System.out.println(a + " % " + b + " = " + (a%b)); break;
		default: System.out.println("�߸��Է�");
		
		}				
		// cal = (double)(a/b);
	}

}
