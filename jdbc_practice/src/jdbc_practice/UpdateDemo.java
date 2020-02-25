package jdbc_practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter item code:");
			int id=Integer.valueOf(br.readLine());
			System.out.println("enter item name:");
			String iname=br.readLine();
			System.out.println("enter rate:");
			double price=Double.valueOf(br.readLine());
			System.out.println("enter quantity:");
			int qty=Integer.valueOf(br.readLine());
			System.out.println("Enter Date:");
			String doc=br.readLine();
			Item obj=new Item();
			obj.setItem_code(id);
			obj.setItem_name(iname);
			obj.setPrice(price);
			obj.setQuantity(qty);
			obj.setDate(doc);
			int r=Item_Dao.update(obj);
			if(r>0) {
				System.out.println("Done.");
			}
			else {
				System.out.println("False.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
