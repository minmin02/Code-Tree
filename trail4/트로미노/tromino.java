import java.util.Scanner;

public class Main {
    
    private static int max = Integer.MIN_VALUE;

    public static void DFS(int y, int x, int[][] grid) {

        if (y >= grid.length) return;

        if (y + 1 < grid.length && x + 1 < grid[0].length) {
            int sum = grid[y][x] + grid[y + 1][x] + grid[y][x + 1] + grid[y + 1][x + 1];
            max = Math.max(max, sum - grid[y][x]);
            max = Math.max(max, sum - grid[y + 1][x]);
            max = Math.max(max, sum - grid[y][x + 1]);
            max = Math.max(max, sum - grid[y + 1][x + 1]);
        }

        if (x + 1 < grid[0].length) {
            DFS(y, x + 1, grid);
        } else {
            DFS(y + 1, 0, grid);
        }
    }

    public static void DFS2(int y, int x, int[][] grid) {

        if (y >= grid.length) return;
    
        if (x + 2 < grid[0].length) {
            int sum = grid[y][x] + grid[y][x + 1] + grid[y][x + 2];
            if (sum > max) max = sum;
        }
       
        if (y + 2 < grid.length) {
            int sum = grid[y][x] + grid[y + 1][x] + grid[y + 2][x];
            if (sum > max) max = sum;
        }

        if (x + 1 < grid[0].length) {
            DFS2(y, x + 1, grid);
        } else {
            DFS2(y + 1, 0, grid);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        DFS(0, 0, grid);
        DFS2(0, 0, grid);
        
        System.out.println(max);
    }
}