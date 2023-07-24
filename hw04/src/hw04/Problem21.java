package hw04;

import java.io.FileInputStream;
import java.util.Scanner;

public class Problem21 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for (int test_case = 1; test_case <= T; test_case++) {
	    	int N = sc.nextInt();
	    	int bug = sc.nextInt();
	    	boolean[][] map = new boolean[N][N];
	    	
	    	int answer = 0;
	    	int[] d1 = {1, 0};
	    	int[] d2 = {0, 1};
	    	for (int i = 0; i < bug; i++) {
	    		int row = sc.nextInt();
	    		int column = sc.nextInt();
	    		int direction = sc.nextInt() - 1;
	    		
	    		if (map[row][column]) {
	    			answer = i + 1;
	    			break;
	    		} else {
	    			map[row][column] = true;
	    		}
	    		
	    		for (int weight = 3; weight > 0; weight--) {
	    			row += d1[direction] * weight;
	    			column += d2[direction] * weight;
	    			if (row < 0 || row >= N || column < 0 || column >= N) break;
	    			if (map[row][column]) {
	    				answer = i + 1;
	    				break;
	    			} else {
	    				map[row][column] = true;
	    			}
	    		}
	    	}
	    	System.out.printf("#%d %d\n", test_case, answer);
	    }
	}

}
