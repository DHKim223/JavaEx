package j01;
	
/*
  ����	���ϴ°� / �޸��Ҵ�
  
  �ڷ���	Ű����	ũ��		�⺻��
  ����	boolean	1bit	false
  ������	byte	1byte	0 				/// 8 bit = 1 byte
  		short	2byte	0
  		int		4byte	0
  		long	8byte	0
  �Ǽ���	float	4byte	0.0
  		double	8byte	0.9
  ������	char	2byte	\u0000
  ���ڿ�			�α����̻� null

  ���� 'A'
  ���ڿ� "ABC"
 
  */



public class VariableEx {
	public static void main(String[] args) {
		boolean a = false;
		System.out.println("booblean : " + a);
		
		
		
		float d = 3.5f; // float d = 3.5; �� 4byte �� 8byte �� �ֱ⿡ ����! // 3.5f / 3.5F �� ������ ��....
		System.out.println("float : " + d );

		//short >> int  / int �� ������ �⺻��
		// �Ǽ��� �⺻�� double
		
		double e = 3.5; // �������� double�� ��� ����.
		System.out.println("double : " + e);
		
		char f = 'f';
		System.out.println("char : "+ f);
		
		
		// sysout + Ctrl + space
		String h = "ABC";
		System.out.println("String : " + h);
		
		String i = "���� �ʹ���հ�~";
		System.out.println("\"String\" : " + i);
		
		
		
	}
}
