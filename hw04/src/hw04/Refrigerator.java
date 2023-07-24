package hw04;

public class Refrigerator extends Product {
	private int volume;
	
	public Refrigerator() {}
	public Refrigerator(String serialNum, String name, int price, int stock, int volume) {
		super(serialNum, name, price, stock);
		this.volume = volume;
	}
	
	public int getVolume() {
		return this.volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	@Override
	public String toString() {
		return "Refrigerator [serial number: " + getSerialNum() + ", name: " + getName() + ", price: " + getPrice() + ", stock: " + getStock() + ", volume: " + getVolume() + "]";
	}
}
