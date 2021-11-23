package j08;

// ��� Inheritance
// �θ� ����� �� ��!!!
// �� �����ڴ� ����

// �ڹٴ� ���߻���� �Ұ���
// ��ſ� �������̽��� Ȱ���ϸ� ���߻���� ����� �� �ִ�.

// CellPhone 				��ȭ���
//									String tel;

//	CaPhone					��ȭ��� + ī�޶���
//									int pixel;

//	Mp3Phone				��ȭ��� + ī�޶��� + mp3���
//									int chord;

// ���� Ŭ������ ���� ������ public
//	�� �ϳ��� ���Ͽ� Ŭ������ ������ �����ϴ� ��� main Ŭ������ public.. �������� default


class CellPhone {
	// ������
	private String tel;				// private ���� protected �� �ٲ��ָ� �Ʒ��� ��밡�� ������....protected�� ������.
	
	// CellPhone Default ������
	public CellPhone() {
		System.out.println("�θ� ����Ʈ ������");     // default�� ȣ��Ǹ� �ƹ��͵� ����.
	}
	
	public CellPhone(String tel) {
		System.out.println("�θ������1");					// �θ������� data �� ������� �ϴ� " tel " �� ��...
		this.tel = tel;
	}
	
	// Getter
	public String getTel() {
		return tel;
	}	
}	

// ��ӹ�����  �Ƶ�class  extends ����class

class CaPhone extends CellPhone{					// ī�޶� ��� + ��ȭ��� ..... ��ȭ��� ���� X ...... ��ӹ޾� ����
	// ������
	private int pixel;
	public CaPhone(String tel , int pixel) {
		//this.tel = tel;												// tel �� private  // ������ ���⼭ tel �� �ʱ�ȭ �ϴ°� �Ұ���
		super(tel); 				//super�� ���� ����.. // �θ������� ������ �����⸸    // super() �� �θ� �����ڸ� ȣ��. 
		this.pixel = pixel;
		System.out.println("�θ������2");
	}
	
	// Getter
	public int getPixel() {
		return pixel;
	}
}

class Mp3p extends CaPhone{		// MP3 ��� + ��ȭ��� + ī�޶� ���
	// ������
	private int chord;
	public Mp3p(String tel, int pixel, int chord) {
		
		super(tel, pixel);
		this.chord = chord;
	}
	// Getter
	public int getChord() {
		return chord;
	}
}

public class InherEx {
	public static void main(String[] args) {				
//		CellPhone cp = new CellPhone("1111-2222");
//		System.out.println("��ȭ��ȣ : " + cp.getTel());
		
		//CaPhone ca = new CaPhone(4000);					// tel �� pixel �� ��� �� ������ �ִ�.
		
//		CaPhone ca = new CaPhone("1111-2222",4000);				// �̰� �޾��� �����ڰ� ��� ����	
//		System.out.println("��ȭ��ȣ : " + ca.getTel());
//		System.out.println("ȭ�� : " + ca.getPixel());
		
		Mp3p mp = new Mp3p("1111-2222", 4000, 64 );
		System.out.println("��ȭ��ȣ : " + mp.getTel());
		System.out.println("�ȼ� : " + mp.getPixel());
		System.out.println("ȭ�� : " + mp.getChord());

		
		
	}
}

//�������� ������ ��ü �ʱ�ȭ..... �ڽ�Ŭ�������� ��ü�� �ڽ��� ,,, �θ�Ŭ�������� ��ü�� �κ���...
