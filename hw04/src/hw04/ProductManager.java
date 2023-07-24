package hw04;

public class ProductManager {
	private Product[] products;
	private int idx = 0;
	private int MAX = 10;
	private static ProductManager man = new ProductManager();
	
	private ProductManager() {
		this.products = new Product[MAX];
	}
	
	public static ProductManager getInstance() {
		if (man == null) man = new ProductManager();
		return man;
	}
	public int addProduct(Product p) {
		if (idx == MAX) {
			Product[] tmp = new Product[MAX * 2];
			System.arraycopy(products, 0, tmp, 0, idx);
			products = tmp;
			MAX *= 2;
		}
		products[idx++] = p;
		return idx;
	}
	public void printProduct() {
		for (int i = 0; i < idx; i++) {
			System.out.println(products[i].toString());
		}
	}
	public void updateProduct(int i, Product p) {
		products[i] = p;
	}
	public void deleteProduct(int i) {
		products[i] = products[idx - 1];
		idx--;
	}
	public Product findProduct(String name) {
		for (int i = 0; i < idx; i++) {
			if (products[i].getName().equals(name)) {
				return products[i];
			}
		}
		return null;
	}
	public void printOnlyTV() {
		for (int i = 0; i < idx; i++) {
			if (products[i] instanceof TV)
				System.out.println(products[i].toString());
		}
	}
	public void printOnlyRefrigerator() {
		for (int i = 0; i < idx; i++) {
			if (products[i] instanceof Refrigerator)
				System.out.println(products[i].toString());
		}
	}
}
