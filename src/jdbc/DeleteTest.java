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
		// id , passwd Ȯ��
		try {			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				// ���̵� ����
				if ( passwd.equals(rs.getString("passwd"))) {       // passwd(�Է��� ���).equals ( rs.getString("passwd" (db)))
					// ��й�ȣ�� ����.
					sql = "delete from dbtest where id = '"+id+"' ";
					int result = stmt.executeUpdate(sql);
					if ( result == 0) {
						//Ż�� ���� -- DB ����
						System.out.println("Ż�� ó�� ����, DB ����");
					} else {
						// Ż�� ����
						SelectTest st = new SelectTest();
						st.connection();		// Ȯ��...
						st.getMember();
						st.getCount();
					}
				} else {
					// ��й�ȣ �ٸ���.
					System.out.println("��й�ȣ�� ��ġ���� �ʴ´�.");
				}
			} else {
				// ���̵� ����
				System.out.println("�Է��� ���̵� ����.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		dt.getConnection();
		dt.deleteMember("hhh", "111"); // id �� passwd �� �Է¹޾� ��������.... 
		
	}
}
