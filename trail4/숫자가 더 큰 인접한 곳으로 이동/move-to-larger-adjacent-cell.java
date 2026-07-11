import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        // 탐색이기 때문에 0,0 인덱스부터 할 필요 x
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int currentCol = c;
        int currentRow = r;
        int currentValue = grid[r][c]; 

        while (true) {
            boolean moved = false; 

            // 상, 하, 좌, 우 순서대로 탐색
            for (int i = 0; i < 4; i++) {
                int row = dRow[i] + currentRow;
                int col = dCol[i] + currentCol;

                if (row >= 1 && row <= n && col >= 1 && col <= n) {
                    int targetValue = grid[row][col]; 

                    if (targetValue > currentValue) {
                        q.offer(currentValue);
                        currentCol = col;
                        currentRow = row;
                        currentValue = targetValue;
                        moved = true; 
                        break; 
                    }
                }
            }
            
            if (!moved) {
                q.offer(currentValue); 
                break;
            }
        }
        
   
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}