package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaPJ {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public JavaPJ() {
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
				// ���̵� �ִ°��
				System.out.println("���̵� �ֽ��ϴ�. ����� �� �����ϴ�.");
			} else {
				// ���̵� ���°��
				sql = "insert into dbtest values (' "+id+" ', '"+passwd+"', '"+name+"', '"+tel+"' , ' "+address+" ' )";
				int result = stmt.executeUpdate(sql); // �۾��� �� ��
				if( result == 0) {
					// �۾� ���� - DB ����
					System.out.println("ȸ������ ����");
				} else {
					// �۾� ����
					System.out.println("ȸ�����Կ� ����");
					SelectTest st = new SelectTest();
					st.connection();
					st.getMember();										// ��ü���
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
		// 프로젝트 메인으로 갈것들......
		// getText 로 아이디 비번 읽어와서 저장해놓기... 저장해놓은 변수를 insertMember(_____) 여기에 사용
		//
//		JavaPJ pj = new JavaPJ();
//		pj.getConnection ();		
//		pj.insertMember ( id, passwd, name ,tel ,address);
//		
	}
}
