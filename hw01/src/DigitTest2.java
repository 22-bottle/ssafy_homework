public class DigitTest2 {

	public static void main(String[] args) {
		
		int N = 5;
		float half = (float)N / 2;
		int num = 1;
		int blank = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < blank; j++) System.out.print("   ");
			for (int j = 0; j < N - blank * 2; j++) System.out.printf("%3d", num++);
			for (int j = 0; j < blank; j++) System.out.print("   ");
			System.out.println();
			
			if (i + 1< half) blank++;
			else if (i + 1 == half) continue;
			else blank--;
		}
	}

}
