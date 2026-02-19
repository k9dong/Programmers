class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                count++;
            }else{
                count--;
            }
            
            if(count <0) break;
        }
        if(count==0) return true;
        

        return answer;
    }
}