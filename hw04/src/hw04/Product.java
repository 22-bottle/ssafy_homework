package hw04;

public class Product {
	private String serialNum;
	protected String name;
	private int price;
	private int stock;
	
	public Product() {};
	public Product(String serialNum, String name, int price, int stock) {
		this.setSerialNum(serialNum);
		this.setName(name);
		this.setPrice(price);
		this.setStock(stock);
	}
	
	public String getSerialNum() {
		return this.serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return this.stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
