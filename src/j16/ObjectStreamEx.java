package j16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

// 객체단위 입출력
// ObjectInputStream / ObjectOutputStream

class User implements Serializable{									// struct in c == bean class in java
	private String name;
	private int age;
	private String address;
	public User ( String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getAddress(){
		return address;
	}
}

public class ObjectStreamEx {
	public static void main(String[] args) {
		// 객체생성
		FileInputStream fis = null;									
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;			
		
		
		try {
			// 여러객체단위 입출력
			fos = new FileOutputStream ( "src/j16/result.ser");
			oos = new ObjectOutputStream(fos);
			
			User kim = new User("������", 30, "�����");
			oos.writeObject(kim);
			
			fis = new FileInputStream("src/j16/result.ser");	// fos 보다 fis가 먼저오면 빈파일을 읽어버려서 fos먼저
			ois = new ObjectInputStream(fis);
			User user = (User)ois.readObject(); // readObject 는 return object.... user �� ����ȯ�� �־����
			
			System.out.println("�̸� : " + user.getName());
			System.out.println("���� : " + user.getAge());
			System.out.println("�ּ� : " + user.getAddress());
			System.out.println("");
			
			// bean class 단위 입출력
			Vector <User>  v = new Vector <User> ();
			v.add(new User("ㄱ",30,"ㄴ"));
			v.add(new User("ㄷ",30,"ㄹ"));
			v.add(new User("ㅁ",30,"ㅂ"));
			v.add(new User("ㅅ",30,"ㅇ"));
			v.add(new User("ㅈ",30,"ㅊ"));
			oos.writeObject(v);
			
			Vector<User> vv = new Vector<User>();
			vv = (Vector<User>)ois.readObject();

			for(int i=0; i<vv.size(); i++){
				System.out.println("이름 : " + vv.get(i).getName());
				System.out.println("나이 : " + vv.get(i).getAge());
				System.out.println("주소 : " + vv.get(i).getAddress());
				System.out.println("");
			}
			
			// Map을 이용해서,,,    위에는 getter를 이용함
			HashMap <String, User> hm = new HashMap <String, User>();
			hm.put("kim", new User("김유신", 20 , "서울시"));
			hm.put("lee", new User("이순신", 20 , "충남시"));
			hm.put("hong", new User("홍길동", 20 , "인천시"));

			oos.writeObject(hm);
			
			HashMap <String,User> h = ( HashMap<String, User> )ois.readObject();
			Iterator <String> i = h.keySet().iterator();
			while(i.hasNext()) {
				String key = i.next();
				User value = h.get(key);
				System.out.println(key);
				System.out.println( value.getName() + " : " + value.getAge()+ " : " + value.getAddress());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch ( IOException e) {
			e.printStackTrace();
		} catch( ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if( fos != null) fos.close();
				if( oos != null) oos.close();
				
				if(fis != null) fis.close();
				if(ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
		
	}
}
