import java.util.*;
public class Main {

    static int answer;
    private static int max = Integer.MIN_VALUE;
    
    public void DFS(int currentIndexY,int currentIndexX,int[][]b){
       
    if (currentIndexX > b.length - 3 && currentIndexY > b.length - 3) {
            return;
        }

int count = 0;
        if (currentIndexY + 3 <= b.length && currentIndexX + 3 <= b.length) {
            for (int i = currentIndexY; i < currentIndexY + 3; i++) {
                for (int j = currentIndexX; j < currentIndexX + 3; j++) {
                    if (b[i][j] == 1) count++;
                }
            }
            if (count > max) max = count;
        }

        if(currentIndexX==b.length-3){
            if(currentIndexY<b.length-3){
                DFS(currentIndexY+1,0,b);
            }
        }else{
            DFS(currentIndexY, currentIndexX + 1, b);
        }


  }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] b = new int[n][n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m = kb.nextInt();
                b[i][j] = m;
            }
        }

    T.DFS(0,0,b);
        
        System.out.println(max);
    }
}