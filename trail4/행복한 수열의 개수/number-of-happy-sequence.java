import java.util.Scanner;
  
public class Main {
    public static final int MAX_N=100;
    public static int n,m;
    public static int[][]grid=new int[MAX_N][MAX_N];

    public static int[]seq=new int[MAX_N];
    public static boolean isHappySequence(){
        int consecutiveCount=1,maxCcnt=1;
        for(int i=1; i<n; i++){
            if(seq[i-1]==seq[i]){
                consecutiveCount++;
            }else{
                // 연속되지 않은 순간 초기화
                consecutiveCount=1;
            }
            maxCcnt=Math.max(maxCcnt,consecutiveCount);
        }
        return maxCcnt>=m;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int numHappy = 0;
        
        // 먼저 가로로 행복한 수열의 수를 셉니다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                seq[j] = grid[i][j];
            
            if(isHappySequence())
                numHappy++;
        }
        
        // 세로로 행복한 수열의 수를 셉니다.
        for(int j = 0; j < n; j++){
            // 세로로 숫자들을 모아 새로운 수열을 만듭니다.
            for(int i = 0; i < n; i++)
                seq[i] = grid[i][j];
            
            if(isHappySequence())
                numHappy++;
        }

        System.out.print(numHappy);
    }
}