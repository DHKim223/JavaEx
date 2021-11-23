package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public void DeleteTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "joeun";
		String passwd = "joeun";
		try {
			con = DriverManager.getConnection(url,id,passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMember(String id, String passwd) {
		String sql = "select * from dbtest where id = '"+id+"' ";
		// id , passwd 확인
		try {			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				// 아이디가 있음
				if ( passwd.equals(rs.getString("passwd"))) {       // passwd(입력한 비번).equals ( rs.getString("passwd" (db)))
					// 비밀번호가 같다.
					sql = "delete from dbtest where id = '"+id+"' ";
					int result = stmt.executeUpdate(sql);
					if ( result == 0) {
						//탈퇴 실패 -- DB 문제
						System.out.println("탈퇴 처리 실패, DB 문제");
					} else {
						// 탈퇴 성공
						SelectTest st = new SelectTest();
						st.connection();		// 확인...
						st.getMember();
						st.getCount();
					}
				} else {
					// 비밀번호 다르다.
					System.out.println("비밀번호가 일치하지 않는다.");
				}
			} else {
				// 아이디가 없음
				System.out.println("입력한 아이디가 없다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		dt.getConnection();
		dt.deleteMember("hhh", "111"); // id 와 passwd 를 입력받아 지워야함.... 
		
	}
}
