class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int mi = 100;
        int mx = 0;
        for(int i=0; i < 3; i++){
            
                if(lines[i][0] < mi){
                    mi = lines[i][0];
                }
                if(lines[i][1] > mx){
                    mx = lines[i][1];
                }
        }
        int size = mx - mi;
        int[] arr = new int[size];
        
        for(int j=0; j < 3; j++){
            for(int k=lines[j][0]; k < lines[j][1] ; k++)
                arr[k-mi] +=1;
        }
        for (int n : arr) {
              if (n >= 2) answer++;
            }

        
        return answer;
    }
}