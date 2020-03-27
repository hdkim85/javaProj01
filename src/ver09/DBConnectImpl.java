package ver09;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnectImpl implements DBConnect{
	
	public PreparedStatement ps;
	public Statement st;
	public Connection conn;
	public ResultSet result;
	public CallableStatement cs;
	
	
	public DBConnectImpl() {
	
	}
	
	
	public DBConnectImpl(String user, String pass) {
		
		try {
			Class.forName(ORACLE_DRIVER);
			
			connect(user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void connect(String user, String pass) {
		try {
			conn = DriverManager.getConnection(ORACLE_URL, user, pass);
			
		}catch(SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		
	}

	@Override
	public void execute() {
		
	}

	@Override
	public void close() {
		try {
			if(conn!=null) conn.close();
			if(ps!=null) ps.close();
			if(result!=null) result.close();
			if(st!=null) st.close();
			if(cs!=null) cs.close(); 
			
			System.out.println("자원이 모두 반납됨");
			
			
		} catch (Exception e) {
			System.out.println("자원 반납 과정에서 오류가 발생되었습니다.");
			e.printStackTrace();
		}
	}

	@Override
	public String scanValue(String input) {

		Scanner scan = new Scanner(System.in);
		System.out.println(input + "을(를) 입력(exit->종료");
		String inputStr = scan.nextLine();
		
		if("EXIT".equals(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			System.exit(0);
		}
		
		return inputStr;
	}
	
	
	
	
}
