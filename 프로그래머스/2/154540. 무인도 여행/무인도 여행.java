import java.util.*;
class Solution {
    private boolean[][] visited;
    private int n,m;
    public int[] solution(String[] maps) {
        n = maps.length; //행
         m = maps[0].length(); //열
        int[] answer = {};
        int count=0;
        List<Integer> result= new ArrayList<>();
        visited = new boolean[n][m];
         
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (maps[i].charAt(j) != 'X'&& !visited[i][j]){
                    count = dfs(i,j,maps);
                    result.add(count);
                }
            }
        }
        if (result.size()<1) return new int[]{-1};
        
        int [] arr = result.stream().mapToInt(i->i).toArray();
        Arrays.sort(arr);
        return arr;
    }
    private int dfs(int x, int y,String [] maps){
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0';
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny >=0 && n > nx && m > ny&& !visited[nx][ny] && maps[nx].charAt(ny) !='X'){
               sum += dfs(nx,ny,maps);
            } 
        }return sum;
    }
}