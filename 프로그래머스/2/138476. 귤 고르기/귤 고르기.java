import java.util.*;
class Solution {
    //서로 다른 종류의 수를 최소화 수를 최소화
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>(); // 귤번호 갯수
        
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t,0)+1);
            
        }
        
        for(int t : map.values()){
            q.offer(t);
        }
        int sum=0;
        while(sum<k){
            sum+=q.poll();
            answer++;
        }
        
        return answer;
    }
}