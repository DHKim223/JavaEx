package j08;

class NameOil{
	private String name;
	private String oil;
	
	// ����ϸ鼭 ����� ����ϴ� ������
	public NameOil(String name, String oil) {	
		this.name = name;
		this.oil = oil;
	}
	
	public String getName() {
		return name;
	}
	
	public String getOil() {
		return oil;
	}
}

class Bus extends NameOil{
	private String size;
	public Bus (String name, String oil, String size) {
		super(name,oil);
		this.size = size;	
	}
	
	public String getSize() {
		return size;
	}
}

class Truck extends NameOil {
	private int ton;
	public Truck (String name, String oil, int ton) {
		super(name,oil);
		this.ton = ton;
	}
	
	public int  getTon() {
		return ton;
	}
}

class Suv extends NameOil {
	private int cc;
	public Suv (String name, String oil, int cc) {
		super(name,oil);
		this.cc = cc;		
	}
	
	public int  getCc() {
		return cc;
	}
}

public class InherStudy {

	public static void main(String[] args) {
		Bus bus = new Bus ("��� " , "����", "45 �ν�" );
		System.out.println("�귣�� : " + bus.getName());
		System.out.println("���� : " + bus.getOil());
		System.out.println("�ο��� : " + bus.getSize());
		System.out.println();
		
		Truck truck = new Truck ("����", "����", 10);
		System.out.println("�귣�� : " + truck.getName());
		System.out.println("���� : " + truck.getOil());
		System.out.println("���� : " + truck.getTon());
		System.out.println();
		
		Suv suv = new Suv ("�ƿ��" , "�ֹ���" , 2000);
		System.out.println("�귣�� : " + suv.getName());
		System.out.println("���� : " + suv.getOil()) ;
		System.out.println("��ⷮ : " + suv.getCc());
		System.out.println();
	}

}
