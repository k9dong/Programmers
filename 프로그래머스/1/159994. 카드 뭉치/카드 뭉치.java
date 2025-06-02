import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue <String> queue = new LinkedList<>();
        for (String word : goal){
            queue.offer(word);
            
            }
        for (int i=0; i<goal.length; i++){
                if(cards1[i] == queue.poll || cards2[i] == queue.poll) continue;
            if(!queue.isEmpty()) return "No";
        }
        return "Yes";
    }
}