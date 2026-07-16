import java.util.Scanner;

public class Main {
    static int k, n;
    static int[] path; 

   
    static private void dfs(int depth) {
       
        if (depth == n) {
            for (int num : path) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        
        for (int i = 1; i <= k; i++) {
            path[depth] = i; 
            dfs(depth + 1);  
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        path = new int[n]; 
        dfs(0); 
    }
}