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
		InsertTest it = new InsertTest();
		it.getConnection ();
		String id = "hhh";
		String  passwd = "111";
		String name = "ȫ�浿";
		String tel = "1111-2222";
		String address = "������";
		
		it.insertMember ( id, passwd, name ,tel ,address);
		
	}
}
