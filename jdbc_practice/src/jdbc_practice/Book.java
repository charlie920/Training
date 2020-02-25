package jdbc_practice;
import java.io.*;
import java.sql.DriverManager;
import java.sql.*;
public class Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter book id:");
			int book_id=Integer.valueOf(br.readLine());
			System.out.println("Enter Subject:");
			String subject=br.readLine();
			System.out.println("Enter Book Name:");
			String book_name=br.readLine();
			System.out.println("Enter Writer Name:");
			String writer=br.readLine();
			System.out.println("Enter Number of pages:");
			int page_no=Integer.valueOf(br.readLine());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","charlie","1234");
			PreparedStatement ps=c.prepareStatement("insert into Book values(?,?,?,?,?)");
			ps.setInt(1,book_id);
			ps.setString(2, subject);
			ps.setString(3, book_name);
			ps.setString(4, writer);
			ps.setInt(5, page_no);
			int x=ps.executeUpdate();
			if(x>0)
				System.out.println("Done");
			else
				System.out.println("Fail");
			c.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
