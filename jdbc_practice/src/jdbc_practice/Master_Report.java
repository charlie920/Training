package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

public class Master_Report {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List list=Item_Dao.display();
			Iterator it=list.iterator();
			System.out.println("Date\t\t\tItemCode\t\t\tItemName\t\t\tRate\t\t\tQuantity");
			while(it.hasNext()) {
				Item rs=(Item)it.next();
				double amt=rs.getPrice()*rs.getQuantity();
				System.out.println(rs.getDate()+"\t"+rs.getItem_code()+"\t"+rs.getItem_name()+"\t"+rs.getQuantity());
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}/**
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","charlie","1234");
PreparedStatement ps=c.prepareStatement("select * from Master ");
ResultSet rs=ps.executeQuery();
System.out.println("Item code\t Item Name\t Rate\t Quantity\t Date");
while(rs.next()) {
	System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDouble(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs
	.getString(5));
**/
