package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC 			Select
public class SelectTest {
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public SelectTest() {
		// ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				// ��ü ���� ..... ���� �ٲ�� ��ü�� ��� ���Ͱ��� ��ü���� �Ѵ�.
			System.out.println("����̹� �ε�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void connection() {
		// DB ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "joeun";
		String passwd = "joeun";
		try {
			con = DriverManager.getConnection(url, id, passwd);
			System.out.println("DB ���Ἲ��");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getMember() {
		// select all
		String sql = "select * from dbtest";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);		// rs has all data, tf interate to print out them.
				// executeQuery() 			DB�� �� �ٲ�� ��� 				select
				// executeUpdate()			DB�� �ٲ�� ���					insert update delete
			while (rs.next()) {
				System.out.println(
					rs.getString("id") 
					+ "\t" + rs.getString("passwd")
					+ "\t"+ rs.getString("name")
					+ "\t" + rs.getString("tel")
					+ "\t" + rs.getString("address")
				);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( stmt!=null) stmt.close();
				if (rs!=null) rs.close();
			} catch (SQLException e ) {
				e.printStackTrace();
			}
		}
	}
	
	public void getMember(String id) {
		String sql = "select * from dbtest where id ='" + id + "'";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if ( rs.next()) {
				// ���̵� �ִ°��
				System.out.println( "���̵� : " + rs.getString("id") );
				System.out.println("��й�ȣ : " + rs.getString( "passwd"));
				System.out.println("��ȭ��ȣ : " + rs.getString("tel"));
				System.out.println("�ּ� : " + rs.getString("address"));
							
			} else {
				// ���̵� ���� ���
				System.out.println("�Է��� ID  �� �����ϴ�.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( stmt!=null) stmt.close();
				if (rs!=null) rs.close();
			} catch (SQLException e ) {
				e.printStackTrace();
			}
		}
	}
	
	public void getCount () {
		String sql = "select count(*) from dbtest";
		int count = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if( rs.next()) {
				count = rs.getInt( 1 );	// index�� ��������.
			}
			System.out.println("ȸ���� : " + count);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( stmt!=null) stmt.close();
				if (rs!=null) rs.close();
			} catch (SQLException e ) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// ����̹� �ε� _ ���� �ѹ��� �ϸ� �ż� �����ڷ�,,,,		
		SelectTest st = new SelectTest();
		st.connection();
		st.getMember();
		st.getCount();
		System.out.println();
		
		st.getMember("bbb"); // ID �� primary key!
		
	}
}
