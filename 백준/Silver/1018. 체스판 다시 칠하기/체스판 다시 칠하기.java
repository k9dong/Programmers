import java.util.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 세로
        int M = sc.nextInt(); // 가로
        sc.nextLine(); // 버퍼 제거

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        // 가능한 모든 8x8 구간 검사
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, countRepaint(i, j));
            }
        }

        System.out.println(answer);
    }

    // (x, y)를 시작으로 8x8 검사
    static int countRepaint(int x, int y) {
        int whiteStart = 0; // 왼쪽 위가 W인 경우 다시 칠해야 하는 칸 수
        int blackStart = 0; // 왼쪽 위가 B인 경우

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                char current = board[i][j];
                // (i+j)의 합이 짝수면 시작 색과 같아야 함
                if ((i + j) % 2 == 0) {
                    if (current != 'W') whiteStart++;
                    if (current != 'B') blackStart++;
                } else { // 홀수면 시작 색과 달라야 함
                    if (current != 'B') whiteStart++;
                    if (current != 'W') blackStart++;
                }
            }
        }
        return Math.min(whiteStart, blackStart);
    }
}
