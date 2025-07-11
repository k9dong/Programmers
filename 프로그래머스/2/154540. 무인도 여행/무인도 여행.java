import java.util.*;
class Solution {
    static int n;
    static int m;
    private static boolean [][] visited;
    
    public int[] solution(String[] maps) {
        List<Integer> arr = new ArrayList<>();
        n = maps.length; // 행
        m = maps[0].length(); // 열
        visited = new boolean [n][m];
        
        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                char c = maps[i].charAt(j);
                if (!visited[i][j] && c != 'X'){
                    
                    int sum = dfs(i, j, maps);
                    arr.add(sum);
                }
            }
        }
        if(arr.isEmpty()) return new int[]{-1};
        Collections.sort(arr);
        return arr.stream().mapToInt(i->i).toArray();
        
       
    }
    private int dfs (int x, int y, String [] maps){
        visited[x][y] = true;
        int [] dx = {1, -1, 0, 0};
        int [] dy = {0, 0, 1, -1};
        int count = maps[x].charAt(y) - '0';
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >=0 && nx <n && ny <m && !visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                count += dfs(nx,ny,maps);
            }
        }return count;
    }
    
}