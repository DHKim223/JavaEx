package j01;

/*
	1. ���� ������
		++ --
	2. ��� ������
		* / % + -
	*3. ����Ʈ ������
		<< >> >>>
	4. �� ������
		< > <= >= == !=
	*5. ��Ʈ ������
		& | ^ ~				~ ( 1�� ���������� / bit not) �� 1��
	6. �� ������
		&& || ! 			! (���������� / �� not) �� 1��
	*7. ����(����)������
		? :
	8. ���Կ�����
		= += -+ *= /= %=		
 */


public class OperatorEx {
	public static void main(String[] args) {
		//����������
		int a = 10, b=10;
		System.out.println("a :" + a  + "\t" + "b : " + b);
		
		//������  b=++a; -> a,b = 11  / b=a++; a=10 b=11
		b = ++a;
		System.out.println("a :" + a  + "\t" + "b : " + b);
		
		b = a++;	//������  
		// b= ++a ; a�� 1 ������Ű�� b�� ����.  // b=a++; a�� b�� ������ �� 1����
		System.out.println("a :" + a  + "\t" + "b : " + b);
		
		//���������
		System.out.println(5/2);
		System.out.println(5/2.0);
		System.out.println(5/(double)2);
		System.out.println(5/2f); //�Ǽ��켱
		System.out.println('A'+1); // ���� 2byte + ���� 4byte
		System.out.println('A'+'1'); // �Ǽ� over ����
		System.out.println('A'+"1");
		
		int c=20;
		System.out.println(c>>2); //���������� �ι� 20 = 10100  20>>2 = 101  >> �� %2�� ����.... �Ҽ������� 
		System.out.println(c<<2); //�����̵� = *2�� ����
		System.out.println(c>>>2);
		
		//��Ʈ ��������            = �� ���Կ�����.  �������� ���ʿ� ����
		
		a=20;
		b=12;
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b);
		
		//��������
		boolean t = true;
		boolean f = false;
		System.out.println(t && t);
		System.out.println(f && f);
		System.out.println(f && t);
		System.out.println(t && f);
		
		System.out.println(t || t);
		System.out.println(f || f);
		System.out.println(f || t);
		System.out.println(t || f);
		
		int d= 8;
		System.out.println(~d+1); //0�� ����� ���Ե�. a �� -(a+1) �� �ȴ�.
		
		System.out.println(5 != 6);
		System.out.println(5 != 5);
		
		System.out.println(!(5>3));
		
		//���Կ�����
		// = �� �ܼ� ���� ������
		// +=   -=   *=    /=    %=  ��� ���Կ�����
		
		int e = 5;
		System.out.println(e += 2);  // 1 �̿��� �� ����...
		}
}
