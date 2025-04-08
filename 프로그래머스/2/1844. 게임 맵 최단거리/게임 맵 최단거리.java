import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int height = maps.length;
        int width = maps[0].length;

        // 방향: 하, 상, 우, 좌
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= height || ny >= width)
                    continue;

                // 벽이거나 이미 방문한 경우
                if (maps[nx][ny] != 1)
                    continue;

                // 거리 갱신 및 큐에 추가
                maps[nx][ny] = maps[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        // 도착지 값이 여전히 1이면 도달 못한 것
        int answer = maps[height - 1][width - 1];
        return answer == 1 ? -1 : answer;
    }
}
