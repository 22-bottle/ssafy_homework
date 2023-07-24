package hw04;

import java.io.FileInputStream;
import java.util.Scanner;

public class Problem32 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for (int test_case = 1; test_case <= T; test_case++) {
	    	int Y = sc.nextInt();
	    	int X = sc.nextInt();
	    	int N = sc.nextInt();
	    	int[][] map = new int[Y][X];
	    	for (int i = 0; i < Y; i++) {
	    		for (int j = 0; j < X; j++) {
	    			map[i][j] = sc.nextInt();
	    		}
	    	}
	    	int[] rows = new int[N];
	    	int[] columns = new int[N];
	    	int[] chances = new int[N];
	    	for (int i = 0; i < N; i++) {
	    		rows[i] = sc.nextInt() - 1;
	    		columns[i] = sc.nextInt() - 1;
	    		chances[i] = sc.nextInt();
	    	}
	    	int trap = sc.nextInt();
	    	for (int i = 0; i < trap; i++) {
	    		int row = sc.nextInt() - 1;
	    		int column = sc.nextInt() - 1;
	    		map[row][column] = -10;
	    	}
	    	
	    	int sum = -1000 * N;
	    	int[] d1 = {0, 1, 0, -1};
	    	int[] d2 = {1, 0, -1, 0};
	    	for (int i = 0; i < N; i++) {
	    		boolean flag = false;
	    		int row = rows[i];
    			int column = columns[i];
	    		for (int c = 0; c < chances[i]; c++) {
	    			int direction = map[row][column] / 10 - 1;
	    			int length = map[row][column] % 10;
	    			row += d1[direction] * length;
	    			column += d2[direction] * length;
	    			if (row < 0 || row >= Y || column < 0 || column >= X) {
	    				flag = true;
	    				break;
	    			}
	    		}
	    		if (!flag) {
	    			sum += map[row][column] * 100;
	    		}
	    	}
	    	System.out.printf("#%d %d\n", test_case, sum);
	    }
	}

}
