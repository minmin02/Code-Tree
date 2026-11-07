import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] scores = new int[4][n];   // 0~2: 대회, 3: 합계

        for (int contest = 0; contest < 3; contest++) {
            for (int i = 0; i < n; i++) {
                scores[contest][i] = sc.nextInt();
                scores[3][i] += scores[contest][i];   // 합계 누적
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int contest = 0; contest < 4; contest++) {
            // 1. 복사해서 내림차순 정렬
            Integer[] ods = new Integer[n];
            for (int i = 0; i < n; i++) {
                ods[i] = scores[contest][i];
            }
            Arrays.sort(ods, Collections.reverseOrder());

            // 2. 점수 → 등수 표 만들기 (처음 나온 위치만 기록)
            int[] rankOf = new int[3001];
            for (int i = 0; i < n; i++) {
                int cur = ods[i];
                if (i == 0 || cur != ods[i - 1].intValue()) {
                    rankOf[cur] = i + 1;
                }
            }

            //점수를 인덱스로 두면서 그 점수에 대한 등스를 매김 
            
            for (int i = 0; i < n; i++) {
                sb.append(rankOf[scores[contest][i]]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}