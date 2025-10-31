import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 5;
        int current = 0;
        
        if (cacheSize == 0) return cities.length * 5;
        
        
        
        Queue<String> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        q.offer(cities[0].toUpperCase());
        list.add(cities[0].toUpperCase());
        
        for(int i=1; i<cities.length; i++){
            String c = cities[i].toUpperCase();
            if(list.contains(c)){// 캐시에 있을때
                if(list.size() < cacheSize){//아직 캐시가 다 안찼을때
                    answer++;
                    list.add(c);
                }else{//캐시가 다찻을때
                    list.remove(c);
                    list.add(c);
                    answer++;
                }
                
            }else{// 캐시에 없을때
                if(list.size() < cacheSize){
                    q.offer(c);
                    list.add(c);
                    answer+=5;
                }else{
                    list.remove(0);
                    list.add(c);
                    answer+=5;
                }
            }
        }
        return answer;
    }
}