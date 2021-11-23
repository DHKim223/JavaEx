package j07;

  class car{
	public void go() {
		System.out.println("가다");
	}
}

public class Exercise2 {

	public static void main(String[] args) {
		
		car c = new car();
		c.go();
		int [] [] arr = {
				{1},
				{1,2},
				{1,2,3},
				{1,2,3,4}
		
		};
		System.out.println(arr.length);
		System.out.println(arr[2].length);
		for (int i = 0; i<arr.length; i++) {
			for(int j =0 ; j<arr[i].length;j++) {
				System.out.print(arr[i][j]);
			}System.out.println();
		}
	}

}
