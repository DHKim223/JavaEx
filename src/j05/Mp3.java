package j05;

// color				����					�������
// memory			�뷮

// setColor()		������ �Է�		����Լ�
// getColor()		������ ���
// setMemory()	�޸� �Է�
// getMemory()	�޸� ���

public class Mp3 {		//Mp3 �÷��̾� ���赵
	
	private String color;
	private int memory;
	public void setColor( String c ) {
		if(c.equals("������")||c.equals("�Ķ���")||c.equals("�����")){				
		color = c;
		}else {
			System.out.println("�������� �ʴ� �����Դϴ�");
		}
	}
	public String getColor() {
		return color;
	}
	public void setMemory (int m) {
		if( m == 8 || m==32 || m==64) {
			memory = m;
		}	else {
			System.out.println("�������� �ʴ� �뷮�Դϴ�");			
		}
		
	}
	public int getMemory() {
		return memory;
	}	
	
	public static void main(String[] args) {
		Mp3 m3;							// ��������(�����ͺ���)  ���� ��ü���°� �ƴ�.     
												// heap ������ �Ҵ���� �ν��Ͻ��� �ּҸ� ������ ����
		m3 = new Mp3();				// �ν��Ͻ� === ��ü		
												// heap ������ �Ҵ� ���� ������ ���� ����
		
		m3.setColor("������");
		m3.setMemory(8);
		System.out.println("���� : " + m3.getColor());
		System.out.println("�뷮 : " + m3.getMemory());
		
		// ĸ��ȭ - �������� ������
		Mp3 m4 = new Mp3();
		m4.setColor("�Ͼ��");
		m4.setMemory(128);
		System.out.println("���� :"+ m4.getColor());
		System.out.println("�뷮 : "+ m4.getMemory());
		
		
	}
}
