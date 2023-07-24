package hw04;

public class TV extends Product {
	private int inch;
	private String displayType;
	
	public TV() {}
	public TV(String serialNum, String name, int price, int stock, int inch, String displayType) {
		super(serialNum, name, price, stock);
		this.inch = inch;
		this.displayType = displayType;
	}
	
	public int getInch() {
		return this.inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplayType() {
		return this.displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	
	@Override
	public String toString() {
		return "TV [serial number: " + getSerialNum() + ", name: " + getName() + ", price: " + getPrice() + ", stock: " + getStock() + ", inch: " + getInch() + ", display: " + getDisplayType() + "]";
	}
}
