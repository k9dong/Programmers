import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // DP 초기화
        for (int i = 0; i < 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(dp[M][N]);
        }
    }
}
