import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); //K+M−1번째까지
        int k = sc.nextInt(); // k번째부터

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
int start = k - 1;
int end = k + m - 1; // 미만(<) 조건에 쓸 범위

int targetRow = -1;

for (int i = 0; i < n; i++) {
    boolean blocked = false;
    
    for (int j = start; j < end; j++) {
        if (grid[i][j] == 1) {
            blocked = true;
            break;
        }
    }
    
    if (blocked) {
        targetRow = i - 1; 
        break;
    }
    
    targetRow = i; 
}

if (targetRow != -1) {
    for (int l = start; l < end; l++) {
        grid[targetRow][l] = 1;
    }
}

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}