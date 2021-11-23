package j08;

class NameOil{
	private String name;
	private String oil;
	
	// 상속하면서 만들어 줘야하는 생성자
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
		Bus bus = new Bus ("대우 " , "경유", "45 인승" );
		System.out.println("브랜드 : " + bus.getName());
		System.out.println("연료 : " + bus.getOil());
		System.out.println("인원수 : " + bus.getSize());
		System.out.println();
		
		Truck truck = new Truck ("현대", "경유", 10);
		System.out.println("브랜드 : " + truck.getName());
		System.out.println("연료 : " + truck.getOil());
		System.out.println("적재 : " + truck.getTon());
		System.out.println();
		
		Suv suv = new Suv ("아우디" , "휘발유" , 2000);
		System.out.println("브랜드 : " + suv.getName());
		System.out.println("연료 : " + suv.getOil()) ;
		System.out.println("배기량 : " + suv.getCc());
		System.out.println();
	}

}
