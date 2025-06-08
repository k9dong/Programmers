import java.util.*;
class Solution {
    public String solution(String s) {
        int count = 0;
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()){
            if(ch == ' ') {
                count =0;
                sb.append(ch);
                continue;
             }
            if(count%2==0){
                sb.append(Character.toUpperCase(ch));
                count++;
            }else{
                sb.append(Character.toLowerCase(ch));
                count++;
            }
        }
        return sb.toString();
    }
}