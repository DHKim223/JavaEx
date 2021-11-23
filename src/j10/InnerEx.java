package j10;

//����Ŭ����			Inner Class
//Member 			��� ������ ��� �޼����� ���� Ŭ������ ����
//�ܺ� Ŭ������ ����� ������ �� �ִ�.
//static ������ ���� �� ����. 
//��ü�� �����ϱ� ���ؼ��� �ܺ� Ŭ������ ��ü�� ���� �����ؾ� �Ѵ�. 

//Local				Ư���� �޼��� ���� Ŭ������ ���ǵ� ���
//������ ����� ���� �ӽ� Ŭ������ ���
//�޼ҵ� ���ο��� ����ǰ� �޼ҵ� �ȿ����� ��üȭ �� �� �ִ�.
//�޼ҵ� �ܺο����� ����� �� �����ϴ�.
//���ټ����ڸ� ����� �� ����. 

//Static				Ŭ������ static���� ����� ���
//static������ ������ �ִٸ� Ŭ������ static���� �����ؾ� �Ѵ�. 
//�ܺ� Ŭ������ static ����� ������ �� �ִ�.

//Anonymous			������ �� �ִ� �̸��� ���� ���
//�� ���� ����ϰ� ������ �� ��ü�� ���

/*
 	class Outer			-		init a
 								-		disp()				-			class InnerLocal			- 		int c
 																												-		disp()
 								-		class InnerMember											-		int b	
 																												-		disp()
 								-		static	class InnerStatci									-		intd
 								
 	abstract	class InnerAnony	-	int e						�߻�Ŭ���� / ȣ���� �� ����Ŭ������ ȣ��
 												-	disp()
 */

class Outer {									// �ܺ�Ŭ����
	private  int a = 10;						// �������
	public void disp() {						// ����޼���
		System.out.println("Outer a : " + a);
		// System.out.println("InnerMember b : " + b); 	����Ŭ���� ����� �ܺο��� ���Ұ�... �������� ����
		
		///////////// Local Inner Class	///////////
		// Outer class ���� disp() �޼��� �ȿ� Innerlocal Ŭ����
		class InnerLocal{
			private int c = 30;
			public void disp() {
				System.out.println("InnerLocal : " + a);
				System.out.println("InnerLocal : " + c);
			}
		}	//class InnerLocal
		InnerLocal il = new InnerLocal();
		il.disp();
		
	}	// disp()
	
	/////// Member Inner Class ////////
	class InnerMember {					//	��� ����Ŭ����
		private int b= 20;						
		public void disp() {
			System.out.println("InnerMember a : " + a);  // �ܺ�Ŭ���� ����� ������ �� �ִ�
			System.out.println("InnerMember b : " + b); 
		}
	}// class InnerMember
	
	//////// Static Inenr Class ////////////
	static class InnerStatic{						// ����ƽ ����Ŭ����
		private static int d = 40;					// ����Ŭ������ static ������ ���� �� ����. ��, �������� ��� Ŭ������ ����ƽ����
		public void disp() {
			//System.out.println("InnerStatic a : " + a); // Ŭ������ static���� �ٲ��// static �� static����� ���� ����.
			System.out.println("InnerStatic d : " + d);
		}
	}// claas InnerStatic
	
} // class Outer


abstract class InnerAnony{			//�߻�Ŭ����
	int e = 50;
	public abstract void disp();		//�߻�޼���
	
}

public class InnerEx {
	public static void main(String[] args) {
		// Local Inner Class
		Outer out = new Outer(); // Ŭ���� ȣ��... ��ü����\
		out.disp(); // �޼���ȣ��...
		
		// Member Inner Class
		Outer.InnerMember im = out.new InnerMember();
		// �ܺ�Ŭ���� ��ü�� ���ٸ�  Outer.InnerMember im = new Outer().new InnerMember();
		im.disp();
		
		//Static Inner class
		Outer.InnerStatic is = new Outer.InnerStatic();
		is.disp();
		
		// Anonymous Inner Class
		// InnerAnony ia = new InnerAnony();			//�߻�Ŭ������ ��ü���� �Ұ�!!!!! (�̿ϼ��̱� ������)
		InnerAnony ia = new InnerAnony() {// �̿ϼ� �κ� ���� �ϸ� ��밡��// �������� ������ ����.
			// �͸� ����Ŭ����
			public void disp() {
				System.out.println("InnerAnony e : " + e);
			}
		};
		ia.disp();
		
		// ���ֺ��� = ��ü������ �ٽ� ������ ���������� ����°Ŷ� �ѹ����� �������� �ʿ����.
		
		// �͸���Ŭ������ �ֵ� �����....
		new InnerAnony() {
			public void disp() {
				System.out.println("InnerAnony e : " + e);
			}
		}.disp();
		
	}
		
		
}

