package jdbc_practice;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Demo1 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","charlie","1234");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from PSIT");
			System.out.println("Display all records");
			while(rs.next()) {
				System.out.println("Roll no: "+rs.getInt(1));
				System.out.println("name is: "+rs.getString(2));
				System.out.println("course is: "+rs.getString(3));
			}
			c.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
