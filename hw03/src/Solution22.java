

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for (int test_case = 1; test_case <= T; test_case++) {
	    	int N = sc.nextInt();
	    	boolean[][] map = new boolean[N][N];
	    	int bug = sc.nextInt();
	    	int[][] locations = new int[bug][2];
	    	int[] directions = new int[bug];
	    	for (int i = 0; i < bug; i++) {
	    		locations[i][0] = sc.nextInt();
	    		locations[i][1] = sc.nextInt();
	    		directions[i] = sc.nextInt();
	    	}
	    	int alive_bug = 0;
	    	
	    	for (int i = 0; i < bug; i++) {
	    		int row = locations[i][0];
	    		int column = locations[i][1];
	    		if (map[row][column]) {
	    			break;
	    		}
	    		for (int j = 3; j > 0; j--) {
	    			switch (directions[i]) {
	    			case 1:
	    				row -= j; break;
	    			case 2:
	    				row += j; break;
	    			case 3:
	    				column -= j; break;
	    			case 4:
	    				column += j; break;
	    			}
	    			if (row >= N || row < 0 || column >= N || column < 0 || map[row][column]) {
	    				break;
	    			}
	    			if (j == 1) {
	    				map[row][column] = true;
	    				alive_bug++;
	    			}
	    		}
	    	}
	    	System.out.printf("#%d %d\n", test_case, alive_bug);
	    }
	}

}
