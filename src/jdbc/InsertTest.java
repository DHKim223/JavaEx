package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch ( ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public void getConnection () {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "joeun";
		String passwd = "joeun";
		try {
			con = DriverManager.getConnection(url,id,passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertMember (
		String id, String passwd, String name, String tel, String address) {		
		String sql = "select * from dbtest where id='"+id+"'";
		
		try {
			stmt = con.createStatement();				
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				// 아이디 있는경우
				System.out.println("아이디가 있습니다. 사용할 수 없습니다.");
			} else {
				// 아이디 없는경우
				sql = "insert into dbtest values (' "+id+" ', '"+passwd+"', '"+name+"', '"+tel+"' , ' "+address+" ' )";
				int result = stmt.executeUpdate(sql); // 작업한 행 수
				if( result == 0) {
					// 작업 실패 - DB 문제
					System.out.println("회원가입 실패");
				} else {
					// 작업 성공
					System.out.println("회원가입에 성공");
					SelectTest st = new SelectTest();
					st.connection();
					st.getMember();										// 전체출력
				}
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( stmt != null ) stmt.close();
				if( rs != null ) rs.close();
			} catch( SQLException e ) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	   
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.getConnection ();
		String id = "hhh";
		String  passwd = "111";
		String name = "홍길동";
		String tel = "1111-2222";
		String address = "수원시";
		
		it.insertMember ( id, passwd, name ,tel ,address);
		
	}
}
