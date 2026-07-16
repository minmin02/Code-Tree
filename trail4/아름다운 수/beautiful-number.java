import java.util.Scanner;
public class Main {
    static private int answer=0;

private static boolean isBeuty(int[] arr){
    int i = 0;
    while (i < arr.length) {
        int target = arr[i];
        
        // 남은 자릿수 확인
        if (i + target > arr.length) return false;
        
        for (int j = 0; j < target; j++) {
            if (arr[i + j] != target) return false;
        }
        
        i += target; 
    }
    return true;
}

    // 나올 수 있는 경우의 수 돌리면서 판별함수로 카운트 ++;
    private static void dfs(int n,int[]arr,int depth){    

        if (depth == n) {
            if (isBeuty(arr)) {
                answer++;
            }
            return;
        }
        for (int val = 1; val <= 4; val++) {
            arr[depth] = val;       
            dfs(n, arr, depth + 1); 
        }
    }

    public static void main(String[] args) {
    
         int[]arr;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=1;
        }
        dfs(n,arr,0);
        System.out.println(answer);
    }
}