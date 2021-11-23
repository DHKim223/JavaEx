package TeamPEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



// 	DbLink db = new DbLink();
// 	if ( 회원가입 ) {
// 	db.register(waitmsg , waitmsg2 ); }
// 	if ( 로그인 ) {
// 	db.signin (waitmsg, waitmsg2) ;}

public class DbLink {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public DbLink() {
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
	
	public String register ( String id, String passwd) throws SQLException{		
			String sql = "select * from ProjectE where id='"+id+"'";
			String msg ;
			
			System.out.println("회원가입 시작.");
			
			stmt = con.createStatement();				
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				// 아이디가 있다.
				System.out.println("사용할 수 없는 아이디 입니다."); // panel 에 띄우기  msg = " ";,  ~.setText(msg);
				msg =  "DB★DB_rej★"+id;
			} else {
				// 아이디가 없다
				sql = "insert into ProjectE values ('"+id+"', '"+passwd+"')";
				int result = stmt.executeUpdate(sql); 
				if( result == 0) {	
					// 작업실패
					System.out.println(" DB 오류로 회원가입 실패 "); // panel 에 띄우기
					msg = "DB★DB_ecep★"+id;
				} else {
					// 작업 성공
					System.out.println(" 회원가입 완료 "); // panel 에 띄우기
					msg = "DB★DB_com★"+id;
					sql = "insert into score values ('"+id+"',0)";
					rs = stmt.executeQuery( sql );
					sql = "commit";
					rs = stmt.executeQuery( sql );
				}
					
				}
			System.out.println("회원가입 끝 / msg : "+msg);
			return msg;
	}
	
	//waitmsg 아이디
	// waitmsg2 패스워드
	public String signin( String id, String passwd ) throws SQLException{
		String sql = "select * from ProjectE where id='"+id+"'";
		String msg;
		System.out.println("로그인 시작 DB");
			stmt = con.createStatement();
			rs = stmt.executeQuery( sql );
			if( rs.next() ) {
				// 아이디가 있다
				if( passwd.equals( rs.getString("passwd") ) ) {
					// 비밀번호가 같다
					System.out.println("로그인 성공"); // panel 에....
					sql = "commit";
					rs = stmt.executeQuery( sql );
					msg =  "DB&DB_sign&"+id;
				} else {
					// 비밀번호가 다르다
					System.out.println( "입력하신 비밀번호가 다릅니다. 다시 확인하세요." );// panel 에....
					 msg ="DB&DB_pass&"+id;
				}				
			} else {
				// 아이디가 없다
				System.out.println( "입력한 아이디가 없습니다. 다시 확인하거나 회원가입 해주세요." );// panel 에....
				msg = "DB&DB_non&"+id;
			}
			System.out.println("로그인 끝 / msg : "+msg);
			return msg;
			
		
	}
	public String Score( String id ) throws SQLException{
		String sql = "select * from score where id='"+id+"'";
		String msg;
		System.out.println("스코어 입력 DB");
			stmt = con.createStatement();
			rs = stmt.executeQuery( sql );
			if( rs.next() ) {
				// 아이디가 있다
					sql = "update score set score=score+10 where id='"+id+"'";
					rs = stmt.executeQuery( sql );
					sql = "commit";
					rs = stmt.executeQuery( sql );
					msg =  "DB&sc&";
			
			} else {
				// 아이디가 없다
				System.out.println( "입력한 아이디가 없습니다. 다시 확인하거나 회원가입 해주세요." );// panel 에....
				msg = "DB&DB_non&"+id;
			}
			System.out.println("스코어 끝 / msg : "+msg);
			return msg;
	}
		
	public String getScore(String id) throws SQLException {
		String sql = "select * from score where id='"+id+"'";
		String msg;
		String score;
		System.out.println("스코어 출력");
		stmt = con.createStatement();
		rs = stmt.executeQuery( sql );
		if( rs.next() ) {
			// 아이디가 있다
				score = rs.getString("score");
				msg =  "DB&"+score;
		
		} else {
			// 아이디가 없다
			System.out.println( "입력한 아이디가 없습니다. 다시 확인하거나 회원가입 해주세요." );// panel 에....
			msg = "DB&DB_non&"+id;
		}
		System.out.println("스코어 끝 / msg : "+msg);
		return msg;
	}
	
	
	public void Close() throws SQLException{
		if(this.stmt !=null)this.stmt.close();
		if(this.rs !=null)this.rs.close();
	}
	
	
}

