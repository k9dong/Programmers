import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
        if(Character.isUpperCase(c)){
            c = (char)((c-'A'+n) % 26 +'A');
            sb.append(c);
        }else if(Character.isLowerCase(c)){
            c = (char) ((c-'a'+n) % 26 +'a');
            sb.append(c);
        }else{
            sb.append(c);
        }
        

        }
        return sb.toString();
    }
}