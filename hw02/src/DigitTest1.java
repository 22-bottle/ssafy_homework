import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] tens = new int[10];
		int count = 0;
		while (true) {
			int num = sc.nextInt();
			if (num == 0) break;
			tens[num / 10]++;
			count++;
		}
		for (int i = 1; count > 0; i++) {
			for (int j = 0; j < 10; j++) {
				if (tens[j] == i) {
					System.out.printf("%d : %d개\n", j, i);
					count -= i;
				}
			}
		}
	}
}
