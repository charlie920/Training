package jdbc_practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class Demo4 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Employee Code: ");
		int Emp_Code=Integer.valueOf(br.readLine());
		System.out.println("Enter Employee name: ");
		String Emp_Name=br.readLine();
		System.out.println("Enter Designation: ");
		String Designation=br.readLine();
		System.out.println("Enter Basic: ");
		int Basic=Integer.valueOf(br.readLine());
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","charlie","1234");
		//Statement st=c.createStatement();
		//ResultSet rs=st.updateQuery("create table Employee(Emp_Code int,Emp_Name varchar2(20),Designation varchar2(20),Basic int");
		PreparedStatement ps=c.prepareStatement("insert into Employee values(?,?,?,?)");
		ps.setInt(1, Emp_Code);
		ps.setString(2,Emp_Name);
		ps.setString(3,Designation);
		ps.setInt(4,Basic);
		int x=ps.executeUpdate();
		if(x>0) {
			System.out.println("Done");
		}else {
			System.out.println("fail");
		}
		c.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
