package j10;

import j10.mypack.MypackOne;
import j10.mypack.MypackTwo;

public class PackageEx {
	public static void main(String[] args) {
		MypackOne mo = new MypackOne();
		MypackTwo mt = new MypackTwo();
		System.out.println(mo.one());
		System.out.println(mt.two());
	}
}
