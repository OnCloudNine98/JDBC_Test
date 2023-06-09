import java.sql.*;
public class jdbcConnectTest {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs	=null;
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql1 = "select * from emp01";
		
//		String sql2= "insert into emp01 "										//삽입
//				+"values (2222,'KIM','SALES',7788,sysdate,1000,null,30)";
		
//		String sql3 = "update emp01 "											//업데이트
//				+ "set empno = 333"
//				+ "where empno = 1111";
		
		String sql4= "delete from emp01 "
				+ "where empno = 2222";
		
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("연결 성공");
			
			stmt = con.createStatement();
//			int result = stmt.executeUpdate(sql2);
			
//			int result = stmt.executeUpdate(sql3);
			
			int result = stmt.executeUpdate(sql4);
			
			if(result <= 0 ) {
				System.out.println("데이터 처리 실패");
			}else {
				System.out.println("데이터 처리 성공");
			}
			
			rs = stmt.executeQuery(sql1);
			
			while(rs.next() ) {
				int empno=rs.getInt(1);
				String ename=rs.getString(2);
				String job = rs.getString(3);
				int mgr=rs.getInt(4);
				Date hiredate=rs.getDate(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				
				
				System.out.println(empno + " : "+ename+" : "+ job
						+" : "+mgr+" : "+hiredate+" : "+sal
						+" : "+comm+" : "+deptno);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		

	}

}
