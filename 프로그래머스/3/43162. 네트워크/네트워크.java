class Solution {
    static boolean [] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean [n];
        int answer = 0;
        for (int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i,computers);
                answer ++;
            }
        } return answer;
    }
    void dfs(int com, int[][] computers){
        visited[com] = true;
        for(int j=0; j<computers.length; j++){
            if(computers[com][j]==1&& !visited[j]){
                dfs(j,computers);
            }
        
        }
    }
}