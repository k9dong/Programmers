class Solution {
    private static int count = 0;
    private static int[] board;
    private static int N;
    public int solution(int n) {
        N=n;
        board = new int[n];
        dfs(0);
        
        
        return count;
    }
    
    private static void dfs(int row){
        if(row==N){
            count++;
            return;
        }
        for(int col=0; col<N; col++){
            if(isValid(row,col)){
                board[row] = col;
                dfs(row+1);
            }
        }
    }
    
    private static boolean isValid(int row, int col){
        for(int i=0; i<row; i++){
            if(board[i]==col || Math.abs(row-i) == Math.abs(col-board[i])){

                return false;
                }
        } return true;
    }
}