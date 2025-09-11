import java.util.*;
class Solution {
    private boolean[][] visited;
    private int toL = 0;
    private int toE = 0;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static int n;
    private static int m;
    
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        for (int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if (maps[i].charAt(j) == 'S'){
                    toLever(i,j,maps);
                }
            }
        }
        if (toL ==0 || toE==0){
            return -1;
        }
        return toL + toE;
    }
    private void toLever(int x,int y, String[] maps){
        Queue<int[]> q = new LinkedList<>();
        int[][] check = new int[maps.length][maps[0].length()];
        q.offer(new int[] {x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            x = cur[0];
            y = cur[1];
            for (int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && ny >=0 && nx <n && ny < m && maps[nx].charAt(ny) == 'L'&& check[nx][ny] ==0){
                    toExit(nx,ny,maps);
                    toL = check[x][y] + 1;
                    return;
                }else if(nx >=0 && ny >=0 && nx <n && ny < m && maps[nx].charAt(ny) !='X'&& check[nx][ny] ==0){
                    q.offer(new int[] {nx,ny});
                    check[nx][ny] = check[x][y] + 1;
                }
            }
        }
        return;
    }
    private void toExit(int x,int y, String[] maps){
        Queue<int[]> q = new LinkedList<>();
        int[][] check = new int[maps.length][maps[0].length()];
        q.offer(new int[] {x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];
            for (int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && ny >=0 && nx <n && ny < m && maps[nx].charAt(ny) == 'E'&& check[nx][ny] ==0){
                    
                    toE = check[x][y] + 1;
                    return ;
                }else if(nx >=0 && ny >=0 && nx <n && ny < m && maps[nx].charAt(ny) !='X'&& check[nx][ny] ==0){
                    q.offer(new int[] {nx,ny});
                    check[nx][ny] = check[x][y] + 1;
                }
            }
        }return;
    }
}