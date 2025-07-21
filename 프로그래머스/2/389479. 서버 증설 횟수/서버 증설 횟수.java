import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0; //가용중인 서버
        Map<Integer, Integer> map = new HashMap<>(); // 종료되는시간, 서버 수
        for (int i=0; i<24; i++){
            if (map.containsKey(i)){
                server -= map.get(i);
            }
            int users = players[i]; // 해당 시간 사용자수
            int needs = users / m; // 해당 시간 필요한 서버수
            if (needs > server){
                int count = needs - server;
                map.put(i+k, count);
                answer += count;
                server+=count;
            }
            
        }
        return answer;
    }
}