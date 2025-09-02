import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> arr = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        long now = toDay(today);//오늘
        
        for(String t : terms){
            String [] parts = t.split(" ");
            map.put(parts[0], Integer.parseInt(parts[1]));
        }
        int i = 1;
        for (String p : privacies){
            String [] parts = p.split(" ");
            String date = parts[0];
            String type = parts[1];
            long d = toDay(date); //가입날짜
            
            long limit = (long) map.get(type) * 28; //유효기간
            if (d+limit <= now){
                arr.add(i);
            }
            
            i++;
                
        }
        
        
        return arr.stream().mapToInt(x->x).toArray();
        
    }
    private long toDay(String d){
        String [] parts = d.split("\\.");
        long year = Long.parseLong(parts[0]);
        long month = Long.parseLong(parts[1]);
        long day = Long.parseLong(parts[2]);
        
        return (year*12*28) + (month * 28) + day;
        
    }
}