import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();       // 숫자의 개수
        M = sc.nextInt();       // 수열의 길이

        arr = new int[N];       // N개의 수 저장할 배열
        result = new int[M];    // 우리가 만들 수열을 저장할 배열

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);       // 사전 순 출력을 위해 정렬

        dfs(0, 0);              // 재귀 함수 호출 (depth=0, start=0)
    }

    // depth: 현재 수열의 길이
    // start: 현재 위치에서 선택 가능한 최소 인덱스 (비내림차순을 위해)
    public static void dfs(int depth, int start) {
        // base case: 수열 길이 M에 도달하면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // 현재 위치(start)부터 N까지 돌면서 숫자 선택
        for (int i = start; i < N; i++) {
            result[depth] = arr[i];      // 현재 depth 자리에 숫자 넣기
            dfs(depth + 1, i);           // 다음 자리(depth + 1) 채우기, i부터 시작 → 중복 허용
        }
    }
}
