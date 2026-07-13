import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][] nextCount = new int[n][n];
        
        // ★ 수정: 문제의 우선순위(상, 하, 좌, 우)에 맞춰 배열을 쌍으로 매칭합니다.
        // 행(Row) 변경량: 상(-1), 하(1), 좌(0), 우(0)
        // 열(Col) 변경량: 상(0), 하(0), 좌(-1), 우(1)
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 구슬 좌표        
        int[][] marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            marbles[i][0] = sc.nextInt();
            marbles[i][1] = sc.nextInt();
        }

        // ★ 추가: 각 구슬이 현재 살아있는지 상태를 관리할 배열 (true: 생존, false: 소멸)
        boolean[] isAlive = new boolean[m];
        for (int i = 0; i < m; i++) isAlive[i] = true;

        for (int i = 0; i < t; i++) {    
            // ★ 추가: 매 초(time)가 시작할 때마다 다음 이동 카운트 배열을 0으로 초기화해야 합니다.
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    nextCount[r][c] = 0;
                }
            }

            for (int j = 0; j < m; j++) {
                if (!isAlive[j]) continue;

                int maxRow = -1;
                int maxCol = -1;
                
                for (int l = 0; l < 4; l++) {  
                    int currentRow = marbles[j][0] - 1 + dRow[l];
                    int currentCol = marbles[j][1] - 1 + dCol[l];
                    
                    if (currentRow >= 0 && currentRow < n && currentCol >= 0 && currentCol < n) {
                        if (maxRow == -1 || grid[maxRow][maxCol] < grid[currentRow][currentCol]) {
                            maxRow = currentRow;
                            maxCol = currentCol;
                        }
                    }
                }
                
                if (maxRow != -1 && maxCol != -1) {
                    nextCount[maxRow][maxCol]++;
                    
                    marbles[j][0] = maxRow + 1;
                    marbles[j][1] = maxCol + 1;
                }
            }

            for (int j = 0; j < m; j++) {
                if (!isAlive[j]) continue;
                
                int r = marbles[j][0] - 1;
                int c = marbles[j][1] - 1;
                
                if (nextCount[r][c] >= 2) {
                    isAlive[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (isAlive[i]) count++;
        }
           
        System.out.println(count);
    }
}