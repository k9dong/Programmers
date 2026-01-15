import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : X.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        Map<Character , Integer> map2 = new HashMap<>();
        for(char c: Y.toCharArray()){
            if(map.containsKey(c) && map.get(c) >0){
                map2.put(c,map2.getOrDefault(c,0)+1);
                map.put(c,map.get(c)-1);
            }
        }
        StringBuilder sb= new StringBuilder();
        for(char c='9'; c>='0'; c--){
            int count = map2.getOrDefault(c,0);
            while(count>0){
                sb.append(c);
                count--;
            }
        }
        if(sb.length()==0) return "-1";
        answer = sb.toString();
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}