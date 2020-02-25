package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3 {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","charlie","1234");
		//	Statement st=c.createStatement();
			//ResultSet rs=st.executeQuery("");
			PreparedStatement ps=c.prepareStatement("create table px3(id number)");
			int x=ps.executeUpdate();
			System.out.println(x);
			if(x>0)
			{
				System.out.println("Done");}
			else
				{System.out.println("Fail");}
			c.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
