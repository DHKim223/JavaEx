package j07;

// String Class
public class SringEx {

	public static void main(String[] args) {
		String s1 = "Hello";								// ���ڿ� - �����ͷ� ���� / �ڹٿ��� String ���� ����
		String s2 = "Hello";								// �ڹٿ����� ���ڿ��� String Ŭ���� ��ü
		
		if ( s1 == s2) System.out.println("����");								// ����		(�ּҺ�)
		else System.out.println("�ٸ���");
	
		if ( s1.equals(s2)) System.out.println("����");						// ����		(������)
		else System.out.println("�ٸ���");
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
		if ( s3 == s4) System.out.println("����");								// �ٸ���	
		else System.out.println("�ٸ���");
	
		if ( s3.equals(s4)) System.out.println("����");						// ����
		else System.out.println("�ٸ���");	
		
		System.out.println();
		
		s1 +=  " Java!!!";
		if ( s1 == s2) System.out.println("����");								// �ٸ���		(�ּҺ�)
		else System.out.println("�ٸ���");

		
		// String Class �� ���ڿ� ������ �� ���� ���̸� ��ȭ��Ű�� �ȵȴ�. ____ Garbage�� �����.
		// ������ ���̸� �ٲܶ��� StringBuffer Ŭ������ ���____ ���� ������ ���´�.
		
		// Method Practice
		System.out.println();
		System.out.println("s1 : " + s1);
		
		System.out.println("charAt : " + s1.charAt(6));
		System.out.println("concat : " + s1.concat("!!"));
		System.out.println("s1 : " + s1);									// StringBuffer �� ������ �ٲ��.
		System.out.println("endsWith : " + s1.endsWith("!!")); // True
		System.out.println("endsWith : " + s1.endsWith("!!!!")); // False
		System.out.println("startsWith : " + s1.startsWith("Hello"));// True
		System.out.println("startsWith : " + s1.startsWith("hello"));// False
		if("ABC".equals("abc"))System.out.println("����");
		else System.out.println("�ٸ���");
		System.out.println("hashCode : " + s1.hashCode());  // int�� ���� �ּ�
		System.out.println("indexOf : " + s1.indexOf('a'));
		System.out.println("lastIndexOf : " + s1.lastIndexOf('a'));
		System.out.println("indexOf : " + s1.indexOf('A'));			//-1 => ����
		System.out.println("isEmpty : " + s1.isEmpty()); // ��������� True.. �����Ͱ� ������ False
		
		System.out.println("length : " + s1.length()); // null ���� ������ ����
		System.out.println("replace : " +s1.replace('a', 'o'));
		
		System.out.println("split : " + s1.split("a"));	//delimiter __ ������   // String �̶� for������ �޾�
		
		String s[] = s1.split("a");
		for ( String a: s) {
			System.out.print( a + "\t");
		}System.out.println();
		
		System.out.println("subString : " + s1.substring(6));				// Java!!!
		System.out.println("subString : " + s1.substring(6,12));			// Java!! (null) ���� 			endIndex  - 1
		System.out.println("toUpperCase : " + s1.toUpperCase());
		System.out.println("toLowerCase : " + s1.toLowerCase());

		String ss = "       a        a        a        ";
		System.out.println("trim : " + ss);					// ���⵵ ������
		System.out.println("trim : " + ss.trim());			// �յڷ� �ʿ���� ���� trim!
	}
}
