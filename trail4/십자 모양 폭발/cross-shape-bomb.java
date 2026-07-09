import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
         
        // 폭탄 시작점 정수
        int start= grid[r-1][c-1];
        
   
            // 단계별 폭탄 처리
            grid[r-1][c-1]=0;
            for(int j=0; j<start; j++){
            if(r-1+j < n) grid[r-1+j][c-1] = 0; // 하
            if(r-1-j >= 0) grid[r-1-j][c-1] = 0; // 상
            if(c-1+j < n) grid[r-1][c-1+j] = 0; // 우
            if(c-1-j >= 0) grid[r-1][c-1-j] = 0; // 좌
            }
            


            
            for(int j=0; j<n; j++){
                int[] temp = new int[n];
                int idx=n-1;
                
            for (int k = n - 1; k >= 0; k--) {
                    if (grid[k][j] != 0) {
                        temp[idx] = grid[k][j];
                        idx--;
                    }
                }
                
                for(int k=0; k<n; k++){
                   grid[k][j]=temp[k];
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