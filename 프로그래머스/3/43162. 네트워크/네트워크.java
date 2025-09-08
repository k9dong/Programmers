class Solution {
    private boolean [] visited;
    private static int count = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean [n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i,computers,n);
                count++;
            }
        }
        return count;
    }
    private void dfs(int x, int[][] computers,int n){
        visited[x] = true;
        for(int i=0; i<n; i++){
            if(computers[x][i] ==1 && !visited[i]){
                dfs(i,computers,n);
            }
        }
    }
}