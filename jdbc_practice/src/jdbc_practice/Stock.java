package jdbc_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter ITEM Code: ");
			int id=Integer.valueOf(br.readLine());
			System.out.println("Enter item name: ");
			String iname=br.readLine();
			System.out.println("Enter price: ");
			double price=Double.valueOf(br.readLine());
			System.out.println("Enter quantity: ");
			int qty=Integer.valueOf(br.readLine());
			System.out.println("Date");
			String doc=br.readLine();
			Item obj=new Item();
			obj.setItem_code(id);
			obj.setItem_name(iname);
			obj.setPrice(price);
			obj.setQuantity(qty);
			obj.setDate(doc);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","charlie","1234");
			PreparedStatement ps=c.prepareStatement("insert into Master values(?,?,?,?,?)");
			ps.setInt(1,obj.getItem_code());
			ps.setString(2,obj.getItem_name());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4,obj.getQuantity());
			ps.setString(5, obj.getDate());			
			int x=ps.executeUpdate();
			System.out.println(x);
			if(x>0) {
				System.out.println("Done.");
			}
			else {
				System.out.println("fail");
			}
			c.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
