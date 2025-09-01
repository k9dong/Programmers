import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int answer = 0;
        // 선물준 사람 <누구에게, 몇개줬는지>
        Map<String, Map<String, Integer>> record = new HashMap<>();
        
        // 선물지수
        Map<String, Integer> point = new HashMap<>();
        
        // 다음달 받을 선물
        Map<String, Integer> count = new HashMap<>();
        
        for (String f : friends){
            record.put(f,new HashMap<>());
            point.put(f,0);
            count.put(f,0);
        }
        
        for (String g : gifts){
            String [] parts = g.split(" ");
            String giver = parts[0];
            String receiver = parts[1];
            
            Map<String, Integer> map = record.get(giver);
            map.put(receiver, map.getOrDefault(receiver,0)+1);
            
            point.put(giver,point.get(giver)+1);
            point.put(receiver, point.get(receiver)-1);
        }
        for(String g : friends){
            for (String r : friends){
                if (g.equals(r)) continue;
                
                int gCount = record.get(g).getOrDefault(r,0); //g가 r에게 준 선물 수
                int rCount = record.get(r).getOrDefault(g,0); //r이 g에게 준 선물 수
                
                if(gCount > rCount){
                    count.put(g, count.get(g)+1);
                }
                else if(gCount == rCount && point.get(g) > point.get(r)){
                    count.put(g, count.get(g)+1);
                }
                
            }
        }
        for (int k : count.values()){
            answer = Math.max(answer, k);
        }

        
        
        return answer;
    }
}