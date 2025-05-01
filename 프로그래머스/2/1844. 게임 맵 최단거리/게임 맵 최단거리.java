import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int height = maps.length-1;
        int width = maps[0].length-1;

        // 방향: 하, 상, 우, 좌
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        //Queue<int[]> queue = new LinkedList<>();
        //queue.offer(new int[]{0, 0});
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx > height || ny > width || nx < 0 || ny <0){
                    continue;
                }
                
                if (maps[nx][ny] !=1){
                    continue;
                }
                
                maps[nx][ny] = maps[x][y] + 1;
                queue.offer(new int[]{nx,ny});
            }
        }

        // 도착지 값이 여전히 1이면 도달 못한 것
        int answer = maps[height][width];
        return answer == 1 ? -1 : answer;
    }
}
