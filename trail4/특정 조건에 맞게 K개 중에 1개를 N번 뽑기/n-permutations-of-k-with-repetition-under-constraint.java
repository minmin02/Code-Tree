import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
            // 종료 조건 : -> n번을 넘을 경우 초기 조건에 출력 후 
            // 백트래킹 return
           
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]);
                if (i < N - 1) sb.append(' ');
            }
            sb.append('\n');
            return;
        }

// num는 1~k번 올 수 있는 거 확인 n번 반복하는걸
// depth로 체크함 -> 인자에 depth 변수로 언제까지 반복하는지 체크

        for (int num = 1; num <= K; num++) {
            if (depth >= 2 && arr[depth-1] == num && arr[depth-2] == num) {
                continue;
            }
            // 1~k 값을 대입 (백트래킹 하면서 값이 계속 오버라이드 됨)
            arr[depth] = num;
            // 깊이를 늘려가면서 N번까지 도달 
            dfs(depth + 1);
        }
    }
}