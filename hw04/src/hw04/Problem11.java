package hw04;

import java.io.FileInputStream;
import java.util.Scanner;

public class Problem11 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for (int test_case = 1; test_case <= T; test_case++) {
	    	int N = sc.nextInt();
	    	char[][] map = new char[N][N];
	    	for (int i = 0; i < N; i++) {
	    		for (int j = 0; j < N; j++) {
	    			String str = sc.next();
	    			map[i][j] = str.charAt(0);
	    		}
	    	}
	    	
	    	int[] d1 = {0, 0, 1, -1};
	    	int[] d2 = {1, -1, 0, 0};
	    	int sum = 0;
	    	for (int i = 0; i < N; i++) {
	    		for (int j = 0; j < N; j++) {
	    			//p 결정
	    			int p = 0;
	    			if (map[i][j] == 'A') p = 1;
	    			else if (map[i][j] == 'B') p = 2;
	    			else if (map[i][j] == 'C') p = 4;
	    			//S counting
	    			for (int d = 0; d < p; d++) {
	    				int k = 1;
    					while (true) {
    						if (i + d1[d] * k >= 0 && i + d1[d] * k < N && j + d2[d] * k >= 0 && j + d2[d] * k < N && map[i + d1[d] * k][j + d2[d] * k] == 'S') {
    							sum++;
    							k++;
    						} else {
    							break;
    						}
    					}
	    			}
	    		}
	    	}
	    	System.out.printf("#%d %d\n", test_case, sum);
	    }
	}

}
