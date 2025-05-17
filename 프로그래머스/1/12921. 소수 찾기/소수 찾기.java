class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i=2; i<=n;i++){
            if (isPrime(i)) answer ++;
        }
        return answer;
    }
    private boolean isPrime(int k){
        if (k == 2) return true;
        if (k %2 ==0) return false;
        int limit = (int)Math.sqrt(k);
        for (int j=3; j<=limit; j+=2){
            if (k%j ==0) return false;
        }
        return true;
    }
}