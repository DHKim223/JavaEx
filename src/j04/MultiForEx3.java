package j04;


//ªÔ¡ﬂ for πÆ

public class MultiForEx3 {

	public static void main(String[] args) {
		for(int i = 0; i<2; i++) {
			for( int j=0; j<3; j+=2) {
				for(int k=0;k<3;k++) {
					System.out.println("i : "+i + "\t" +"j : "+ j +"\t"+ "k : " + k);
				}
			}
		}
	}

}
