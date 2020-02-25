package jdbc_practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Item_Dao 
{
	private static Connection con=null;
	public static Connection getCon()
	{
		try
		{
			if(con==null) //connection become once
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","technology");
		    }
	    }
	catch(Exception e)
	    {
	 	e.printStackTrace();
	    }
		return con;
}

public static int save(Item obj)
{
	int r=0;
	try
	{
	con=getCon();
	PreparedStatement ps=con.prepareStatement("insert into master1 values (?,?,?,?,?)");
	ps.setInt(1, obj.getItem_code());
	ps.setString(2, obj.getItem_name());
	ps.setDouble(3, obj.getPrice() );
	ps.setInt(4, obj.getQuantity());
	ps.setString(5, obj.getDate());
	r=ps.executeUpdate();
    }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return r;
	}
public static List display()
{
	List<Item> al=new ArrayList<Item>(); 
	try
	{
		con=getCon();
		PreparedStatement ps=con.prepareStatement("select * from master1");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Item obj=new Item();
			obj.setItem_code(rs.getInt(1));
			obj.setItem_name(rs.getString(2));
			obj.setPrice(rs.getDouble(3));
			obj.setQuantity(rs.getInt(4));
			obj.setDate(rs.getString(5));
			al.add(obj);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return al;
}
public static int update(Item i)
{
	int r=0;
	try
	{
		con=getCon();
		PreparedStatement ps=con.prepareStatement("update master1 set item_name=?,rate=?,quantity=?,doe=? where item_code=?");
			ps.setString(1, i.getItem_name());
			ps.setDouble(2, i.getPrice());
			ps.setInt(3, i.getQuantity());
			ps.setString(4, i.getDate());
			ps.setInt(5, i.getItem_code());
			r=ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return r;
}
public static int delete(Item i)
{
	int r=0;
	try
	{
		con=getCon();
		PreparedStatement ps=con.prepareStatement("delete from master1  where item_code=?");
			ps.setInt(1, i.getItem_code());
			r=ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return r;
}
public static int search(Item i)
{
	int r=0;
	try
	{
		con=getCon();
		PreparedStatement ps=con.prepareStatement("select *  from master1 where item_code=? OR item_name=? OR rate=? OR quantity=? OR doe=?");
		ps.setInt(1, i.getItem_code());
		ps.setString(2, i.getItem_name());
		ps.setDouble(3, i.getPrice());
		ps.setInt(4, i.getQuantity());
		ps.setString(5, i.getDate());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Item obj=new Item();
			obj.setItem_code(rs.getInt(1));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return r;
}

}
