package j09;

// ������ - ���� ���� �ϳ��� ������ ���� ���� ��

abstract class Design{
	int a=5, b=10;					//�غ�(������) / ����
	double area;	
	public abstract void calc();
	public abstract void disp();	
}

class Rect extends Design {
	public void calc() {
		area = a*b;
	}
	
	public void disp() {
		System.out.println("Rect area : " + area);
	}
}

class Tri extends Design {
	public void calc() {
		area = a*b / 2.0;
	}
	
	public void disp() {
		System.out.println("Tri area : " + area);
	}
}

class Circle extends Design{
	public void calc() {
		area = a*a*Math.PI;
	}
	
	public void disp() {
		System.out.println("Circle area : " + area);
	}
}

class Radder extends Design{
	private int c = 10; // ����
	public void calc() {
		area = (a+c)*b /2.0;
	}
	public void disp() {
		System.out.println("Radder area : " + area);
	}
}


public class PolyEx {
		
	public static void main(String[] args) {
		// ������.... �θ� ȣ�⿡ ���ϴ� �ڽ� Ŭ����/�޼ҵ� ����.... �����ȹݺ��� ������ ��� �ڽ�Ŭ�����޼ҵ� ȣ�Ⱑ��
		// �������� ����� ¥�� �ڵ尡 �ȱ������.
		Design de[] = { new Rect() , new Tri() , new Circle() , new Radder()};	//�θ�Ŭ���������� �ڵ� ����ȯ
		for ( Design d : de) {								
			d.calc();				// Design calc () ȣ��
			d.disp();				// Design disp() ȣ��
		}
		
		
		
		/*
		Rect r = new Rect();
		r.calc();							// �簢���� ���� ����
		r.disp();							// �簢���� ���� ���
		
		Tri t = new Tri();
		t.calc();							// �ﰢ�� ���� ����
		t.disp();							// �ﰢ���� ���� ���
		
		Circle c = new Circle();
		c.calc();							// ���� ���� ����
		c.disp();							// ���� ���� ���
		*/
	}	
}
