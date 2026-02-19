import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c==' '){
                sb.append(c);
                continue;
            }
            if(Character.isUpperCase(c)){
                c = (char) (((c-'A'+n) %26) +'A');
            }else{
                c= (char) (((c-'a'+n)%26) +'a');
            }
            sb.append(c);
        }
        return sb.toString();
    }
}