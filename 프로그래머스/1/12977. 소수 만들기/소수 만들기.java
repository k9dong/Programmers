class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j < nums.length; j++){
                for (int k = j+1; k<nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if (isPrime(sum)) answer +=1;
                }
            }
        }

        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
    private boolean isPrime (int n){
            if (n==1) return false;
            if (n==2) return true;
            if (n%2==0) return false; // 짝수는 소수가 될 수 없다.
            
            for (int i=3; i<=(int)Math.sqrt(n); i+=2){
                if (n%i ==0) return false;
            }
            return true;
        }
}
