package j04;

/*
	������������ �ݾ׺��� �޴��� ����Ѵ�
	������������ ������ ��� ���� �ݾ��� �Է¹ް�
	��ǻ�Ϳ� �����ؼ� �̱�� ���� �ݾ׸�ŭ ���ϰ�
	���� ���� �ݾ׸�ŭ �Ѿ׿��� ����.
	�Ѿ��� ���̳ʽ��� �Ǹ� ������ ����ȴ�.
 
 	<< ����ڰ� �� ����� �� >>
	1.�ָ�
	2.����
	3.���ڱ�
	4.���� �ݾ׺���.
	0.���α׷� ����.
	�޴����� : 4
	����ݾ� : 1000��
	�� �Ұų�?(y/n) : y
	
	1.�ָ�
	2.����
	3.���ڱ�
	4.���� �ݾ׺���.
	0.���α׷� ����.
	�޴����� : 1
	���ñݾ� : 10000
	         user : �ָ�     computer : ���ڱ�
	�����ϴ�. ���� �ݾ� : -9000��
	
	�� �Ұų�?(y/n) : 10000
	���ñݾ��� �����ϴ�.
	���α׷��� ���� �մϴ�.
	
	
	<< ����ڰ� �̱� ����� �� >>	
	1.�ָ�
	2.����
	3.���ڱ�
	4.���� �ݾ׺���.
	0.���α׷� ����.
	�޴����� : 1
	���ñݾ� : 10000
	         user : �ָ�     computer : �ָ�
	�����ϴ�.1000��
	
	�� �Ұų�?(y/n) : y
	
	1.�ָ�
	2.����
	3.���ڱ�
	4.���� �ݾ׺���.
	0.���α׷� ����.
	�޴����� : 2
	���ñݾ� : 10000
	         user : ����     computer : ���ڱ�
	�̰���ϴ�. ����ݾ� : 11000��
	
	�� �Ұų�?(y/n) :
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

class WhileStudy2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int seed = 10000;		
		int result=0;  // 1 �̰�� 2 ���� 3 ���� 
		int batting=0;
		char rep;
		
		do {
		System.out.println("1: ����");
		System.out.println("2: ����");
		System.out.println("3: ��");
		System.out.println("4. ���� �ݾ׺���");
		System.out.println("0. ���α׷� ����");
		System.out.print("�����ϼ��� : ");
		
		int user = Integer.parseInt(br.readLine());
		int com =(int)(Math.random()*3)+1;
		
		if(user == 1 || user==2|| user==3) {
			do {
			System.out.print("���ñݾ� :");
			batting = Integer.parseInt(br.readLine());
			if(seed < batting)System.out.println("�õ庸�� ���� �ݾ��� �����ϼ���");
			}while(batting > seed);
		}
		
		switch(user) {
		case 1: 		
		if(com==1) { //
		System.out.println("user : ����\tcomputer : ����" );
		result = 3;
		}else if(com==2) {
		System.out.println("user : ����\tcomputer : ����" );
		result = 2;
		}else {
		System.out.println("user : ����\tcomputer : ��" );
		result = 1;
		} break;
		
		case 2: if(com==1) { //
		System.out.println("user : ����\tcomputer : ����" );
		result = 1;
		}else if(com==2) {
		System.out.println("user : ����\tcomputer : ����" );
		result = 3;
		}else {
		System.out.println("user : ����\tcomputer : ��" );
		result = 2;
		} break;
		
		case 3: if(com==1) { //
		System.out.println("user : ��\tcomputer : ����" );
		result = 2;
		}else if(com==2) {
		System.out.println("user : ��\tcomputer : ����" );
		result = 1;
		}else {
		System.out.println("user : ��\tcomputer : ��" );
		result = 3;
		} break;
		
		case 4:{
			result = 4; 
		} break;
		
		case 0: {
			result = 5;
		} break;
		default: System.out.print("�߸��� �Է����� ");
		}
		
		if(result == 1) {
			seed += batting;
			System.out.println("�̰���ϴ�!\t�����ܾ� : "+ seed + "��");		// ����ݾ� ǥ��
		}
		else if (result == 2) {
			seed -= batting;
			System.out.println("�����ϴ�!\t�����ܾ� : "+ seed + "��");
		}
		else if (result ==3) {
			System.out.println("�����ϴ�!\t�����ܾ� : "+ seed + "��");
		}
		else if (result ==4)	System.out.println("�����ܾ� : " + seed + "��");
		else break;	

		if(seed <=0) {
			System.out.println("�Ļ����� ���� ���� �Ұ�"); break;
		}
		
		System.out.print("�� �ҷ���? (Y/y): ");
		
		rep = (char)System.in.read();						
		System.in.read();
		System.in.read();						
		
		} while(rep=='y' || rep=='Y');
		
		System.out.println("���� ����");
	}
}
