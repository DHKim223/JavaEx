package j06;

public class ThisEx {

	private String tel;
	private String address;
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setAdd(String address) {
		this.address= address;
	}
	
	public String getTel() {
		return tel;									// this �� ���� �����ϴ�.
	}
	
	public String getAdd() {
		return address;
	}
	
	// �����ڸ� ���� �����ϸ� ����Ʈ �����ڰ� �������.
	// ����Ʈ �����ڸ� ��������� �Ѵ�.
	public ThisEx() {} 	
	public ThisEx( String tel, String address) { // �����͸� �Ѱܹ޴� (�Ű�����)  / ��������
		this.tel = tel;												// ������� = �Ű�����
		this.address = address;								// ������� = �Ű�����
	}
	
	
	public static void main(String[] args) {
		ThisEx te = new ThisEx();
		te.setTel("1111-2222");
		te.setAdd("����");
		System.out.println("Tel : " + te.getTel());
		System.out.println("Add : " + te.getAdd());
		
		ThisEx te1 = new ThisEx("2222-3333", "������");
		System.out.println("Tel : " + te1.getTel());
		System.out.println("Add : " + te1.getAdd());
		
	}

} 
