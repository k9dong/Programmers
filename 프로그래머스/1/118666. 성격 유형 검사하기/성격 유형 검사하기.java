import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap <Character, Integer> map = new HashMap<>();
        char[] allTypes = {'R','T','C','F','J','M','A','N'};
        for (char c : allTypes) {
            map.put(c, 0);
        }
        for (int i=0; i<survey.length; i++){
            char f = survey[i].charAt(0);
            char s = survey[i].charAt(1);
            int score = choices[i];
            
            
            if (score > 4){
                int level = score - 4;
                map.put (s, map.get(s)+level);
            }
            else if (score < 4){
                int level = 4- score;
                map.put(f, map.get(f)+level);
            }
        }
        
        char [][] types = {{'R', 'T'}, {'C', 'F'}, {'J','M'}, {'A','N'}};
        
        for (int i=0; i< types.length; i++){
            char first = types[i][0];
            char second = types[i][1];
            int f_score = map.get(first);
            int s_score = map.get(second);
            
            if (f_score > s_score) answer +=first;
            else if (s_score > f_score ) answer += second;
            else answer += first;
            
        }
        return answer;
    }
}