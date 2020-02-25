package jdbc_practice;

public class Item {
	private int item_code;
	private String item_name;
	private double price;
	private int quantity;
	private String date;
	public int getItem_code() 
	{
		return item_code;
	}
	public void setItem_code(int item_code) 
	{
		this.item_code = item_code;
	}
	public String getItem_name()
	{
		return item_name;
	}
	public void setItem_name(String item_name) 
	{
		this.item_name = item_name;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
}
