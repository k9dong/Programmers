class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        for(int i=0; i<sizes.length; i++){
            int a = Math.max(sizes[i][0],sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);
            
            width = Math.max(width,a);
            height = Math.max(height,b);
        }
        return width * height;
    }
}