import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
	    //System.setIn(new FileInputStream("src/hw02/input.txt"));
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for (int test_case = 1; test_case <= T; test_case++) {
	        int N = sc.nextInt();
	        int[] row_sum = new int[N];
	        int[] column_sum = new int[N];
	        String[][] map = new String[N][N];
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                map[i][j] = sc.next();
	                if (map[i][j].equals("B")) {
	                    row_sum[i]++;
	                    column_sum[j]++;
	                }
	            }
	        }
	        
	        int[] d1 = {-1, -1, -1, 0, 0, 1, 1, 1};
	        int[] d2 = {-1, 0, 1, -1, 1, -1, 0, 1};
	        int max_height = 2;
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (map[i][j].equals("G")) continue;
	                else {
	                    boolean isNearG = false;
	                    for (int k = 0; k < 8; k++) {
	                        if (i + d1[k] < 0 || i + d1[k] >= N || j + d2[k] < 0 || j + d2[k] >= N) continue;
	                        if (map[i + d1[k]][j + d2[k]].equals("G")) {
	                            isNearG = true;
	                            break;
	                        }
	                    }
	                    if (!isNearG && row_sum[i] + column_sum[j] > max_height) {
	                        max_height = row_sum[i] + column_sum[j];
	                    }
	                }
	            }
	        }
	        System.out.printf("#%d %d\n", test_case, max_height - 1);
	    }
	}

}
