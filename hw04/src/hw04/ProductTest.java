package hw04;

public class ProductTest {

	public static void main(String[] args) {
		
		ProductManager man = ProductManager.getInstance();
		
		man.addProduct(new TV("001", "tv1", 100000, 5, 55, "OLED"));
		man.addProduct(new TV("002", "tv2", 200000, 6, 66, "OLED"));
		man.addProduct(new TV("003", "tv3", 300000, 7, 77, "OLED"));
		man.addProduct(new TV("004", "tv4", 400000, 8, 88, "LCD"));
		man.addProduct(new TV("005", "tv5", 500000, 9, 99, "LCD"));
		man.addProduct(new Refrigerator("001", "refrigerator1", 300000, 3, 300));
		man.addProduct(new Refrigerator("002", "refrigerator2", 400000, 4, 400));
		man.addProduct(new Refrigerator("003", "refrigerator3", 500000, 5, 500));
		man.addProduct(new Refrigerator("004", "refrigerator4", 600000, 6, 600));
		man.addProduct(new Refrigerator("005", "refrigerator5", 700000, 7, 700));
		man.addProduct(new Refrigerator("006", "refrigerator6", 800000, 8, 800));
		
		man.printProduct();
		
		TV new_TV = new TV("006", "tv6", 600000, 10, 110, "LCD");
		man.updateProduct(0, new_TV);
		
		man.deleteProduct(1);
		
		TV target = (TV)man.findProduct("tv3");
		System.out.println(target.toString());
		
		man.printOnlyTV();
		man.printOnlyRefrigerator();
		
	}

}
