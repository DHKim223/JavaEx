package j11;
/*

 
Collection			Set				HashSet
												TreeSet
							List				Vector					Stack
												ArrayList
							Queue			LinkedList				
							
 배열은 연속적인 메모리 할당 ( 삽입, 삭제가 불가능)
 
 불연속적인 메모리 공간을 연속화 시켜준다.
 삽입 삭제가 가능하다.
 
 Set					인덱스 없다. 정렬이 안된다. 중복이 안된다. 반복을 돌릴 수 없다.
 						대량의 데이터 관리하면 속도가 느려짐.
 
 List					인덱스가 있어서 중복이 가능하다. 배열과 비슷 . 대량의 데이터도 속도보장
 
 
Map						HashMap
							HashTable
 */
import java.util.HashSet;
public class HashSetEx {
	public static void main(String[] args) {
		//생성
		HashSet <String> hs = new HashSet <String>();
		
		//추가
		System.out.println(" 추가 : "+hs.add("홍길동"));
		System.out.println(" 추가 : "+hs.add("김도헌"));
		System.out.println(" 추가 : "+hs.add("이순신"));
		System.out.println(" 추가 : "+hs.add("홍길동")); // 중복이라 add 불가
		
		//검색
		System.out.println("검색 : " + hs.contains("김도헌"));
		
		//삭제
		System.out.println("삭제 : " + hs.remove("김도헌"));

		System.out.println("크기 : " + hs.size());
		
		//출력	- 	개선된 루프
		for (String s: hs) {						// 배열이나 컬렉션
			System.out.println(s);
		}
		
		
		
	}
}
