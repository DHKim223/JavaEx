package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "joeun";
		String passwd = "joeun";
		
		try {
			con = DriverManager.getConnection(url,id,passwd);
			System.out.println("DB연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateMember(String id, String passwd) {
		String sql = "select * from dbtest where id = '"+id+"'";
		// id , passwd 확인
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				// id 일치하는경우
				if (passwd.equals(rs.getString("passwd"))) {
					// passwd 일치
					String pass = "999";
					String tel = "9999-9999";
					String address = "제주시";
					
					sql ="update dbtest set passwd= ' " 
							 +pass+"', tel='"+tel+"', address = '"+address
							 +"' where id = '"+id+"'";											
							
					int result = stmt.executeUpdate(sql);
					if( result == 0 ) {
						// 탈퇴 실패
						System.out.println("탈퇴실패");
					} else {
						// 탈퇴 성공
						SelectTest st = new SelectTest();
						st.connection();
						st.getMember();
						st.getCount();
					}
					
					
				} else {
					// passwd 불칠치
					System.out.println("비밀번호 불일치");
				}
			} else {
				// id 불일치하는 경우
				System.out.println("비밀번호 불일치");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		ut.getConnection();
		
		String id = "bbb";
		String passwd = "111";
		
		ut.updateMember(id,passwd); // 아이디 비번 확인
		
		
	}
}
