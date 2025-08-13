class Solution {
    public int solution(String s) {
        int answer = 0;
        int xCount = 0;
        int nxCount = 0;
        char x =0;
        String now = "";
        
        for (char c : s.toCharArray()){
            now +=c;
            if(xCount==0){
                x = c;
               xCount++;
            }else if(c==x){
                xCount++;
            }else if(c !=x){
                nxCount++;
                if (xCount == nxCount){
                    xCount=nxCount=0;
                    now += ":";
                }
            }
        }
        String [] parts = now.split(":");
        return parts.length;
    }
}