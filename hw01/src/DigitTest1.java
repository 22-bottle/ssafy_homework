public class DigitTest1 {

	public static void main(String[] args) {
		
		int N = 5;
		int num = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) System.out.print("   ");
			for (int j = 0; j < N - i; j++) System.out.printf("%3d", num++);
			System.out.println();
		}
	}

}
