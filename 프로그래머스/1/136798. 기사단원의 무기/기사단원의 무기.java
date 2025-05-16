class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1 ; i <= number;i++ ){
            int count = 0; // 약수의 갯수
            for (int j=1; j*j <=i ; j++){ // 약수의 갯수를 세는 for문
                if (i%j ==0) {
                    
                count ++;
                
                if (i/j !=j ) {count ++;}
                }
            }
            if (count > limit) answer += power;
            else answer += count;
        }
        return answer;
    }
}