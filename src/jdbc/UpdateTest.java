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
			System.out.println("DB���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateMember(String id, String passwd) {
		String sql = "select * from dbtest where id = '"+id+"'";
		// id , passwd Ȯ��
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				// id ��ġ�ϴ°��
				if (passwd.equals(rs.getString("passwd"))) {
					// passwd ��ġ
					String pass = "999";
					String tel = "9999-9999";
					String address = "���ֽ�";
					
					sql ="update dbtest set passwd= ' " 
							 +pass+"', tel='"+tel+"', address = '"+address
							 +"' where id = '"+id+"'";											
							
					int result = stmt.executeUpdate(sql);
					if( result == 0 ) {
						// Ż�� ����
						System.out.println("Ż�����");
					} else {
						// Ż�� ����
						SelectTest st = new SelectTest();
						st.connection();
						st.getMember();
						st.getCount();
					}
					
					
				} else {
					// passwd ��ĥġ
					System.out.println("��й�ȣ ����ġ");
				}
			} else {
				// id ����ġ�ϴ� ���
				System.out.println("��й�ȣ ����ġ");
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
		
		ut.updateMember(id,passwd); // ���̵� ��� Ȯ��
		
		
	}
}
