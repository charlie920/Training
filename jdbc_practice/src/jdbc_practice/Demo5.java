package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","charlie","1234");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from Employee");
			System.out.println("Display all records");
			System.out.println("*******************************************************************************************************************************************");
			while(rs.next()) {
				System.out.println("Employee Code is: "+rs.getInt(1));
				System.out.println("Employee Name is: "+rs.getString(2));
				System.out.println("Designation is: "+rs.getString(3));
				System.out.println("Basic is:"+rs.getInt(4));
			int Basic=rs.getInt(4);
			int DA=((Basic*65)/100);
			System.out.println("DA :"+DA);
			double HRA=((Basic*33.67)/100);
			System.out.println("HRA :"+HRA);
			double CCA=1500.00;
			System.out.println("CCA :"+CCA);
			double GROSS=Basic+HRA+DA+CCA;
			System.out.println("GROSS:"+GROSS);
			double PF=((Basic*5)/100);
			System.out.println("PF:"+(PF));
			double Loan=1000.00;
			double Deduction=PF+Loan;
			System.out.println("Deduction:"+Deduction);
			double Net=GROSS+Deduction;
			System.out.println("Net :"+Net);
			System.out.println("*******************************************************************************************************************************************");
			}
			c.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
		
	}

}
