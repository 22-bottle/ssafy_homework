package hw04;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution42 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for (int test_case = 1; test_case <= T; test_case++) {
	    	int N = sc.nextInt();
	    	boolean[][] map = new boolean[N][N];
	    	int row = sc.nextInt() - 1;
	    	int column = sc.nextInt() - 1;
	    	int jumper = sc.nextInt();
	    	for (int i = 0; i < jumper; i++) {
	    		map[sc.nextInt() - 1][sc.nextInt() - 1] = true;
	    	}
	    	int[] d1 = {-1, 0, 1, 0};
	    	int[] d2 = {0, 1, 0, -1};
	    	int command = sc.nextInt();
	    	boolean flag = false;
	    	for (int i = 0; i < command; i++) {
	    		int direction = sc.nextInt() - 1;
	    		int length = sc.nextInt();
	    		row += d1[direction] * length;
	    		column += d2[direction] * length;
	    		if (row < 0 || row >= N || column < 0 || column >= N || map[row][column]) {
	    			flag = true;
	    			break;
	    		}
	    	}
	    	if (flag) {
	    		System.out.printf("#%d %d %d\n", test_case, 0, 0);
	    	} else {
	    		System.out.printf("#%d %d %d\n", test_case, row + 1, column + 1);
	    	}
	    }
	}

}
