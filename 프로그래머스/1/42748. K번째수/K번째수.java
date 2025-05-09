import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
    
        for (int l = 0; l < commands.length; l++){
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int [] arr = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(arr);
            int goal = arr[k-1];
            answer.add(goal);
        }
        int [] kk = answer.stream().mapToInt(i -> i).toArray();
        return kk;
    }
}