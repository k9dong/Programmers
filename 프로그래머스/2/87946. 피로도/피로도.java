import java.util.*;
class Solution {
    private static boolean[] visited;
    private static int dl;
    private static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int count =0;
        dl = dungeons.length;
        visited = new boolean [dl];
        dfs(k,dungeons,count);
        return max ;
    }
    
    void dfs(int start, int[][] dungeons,int count){
        
        max = Math.max(max, count);
            
        for (int i=0; i<dl; i++){
            if(dungeons[i][0] <= start && !visited[i]){
            visited[i] = true;
            dfs(start - dungeons[i][1],dungeons,count+1);
            visited[i] = false;
        }
        }
        
    }
    
}