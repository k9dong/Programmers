class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int zeros = 0;
        int zerosCount = 0;
        int l = s.length();
        int n=0;
        int count = 0;
        while(!s.equals("1")){
            zeros = count(s);
            zerosCount += zeros;
            n = s.length()-zeros;
            s = Integer.toString(n,2);
            count++;
        }
        return new int[] {count,zerosCount};
    }
    private static int count(String s){
        int zeros = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                zeros++;
            }
        }return zeros;
    }
}