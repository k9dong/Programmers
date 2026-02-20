import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2= new StringBuilder();
        Map<String,String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                sb2.append(c);
                sb.setLength(0);
                continue;
            }else{
                sb.append(c);
                if(map.containsKey(sb.toString())){
                    String t= map.get(sb.toString());
                    sb2.append(t);
                    sb.setLength(0);
                }
            }
        }
        return Integer.parseInt(sb2.toString());
    }
}