class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 1. 각 줄마다 OR 연산
            int result = arr1[i] | arr2[i];

            String binary = Integer.toBinaryString(result);
            
            
            //binary= String.fromat("%5s", binary).replace('',0)
            binary = String.format("%" + n + "s", binary).replace(' ','0');
                
            answer[i] = binary.replace('1', '#').replace('0', ' ');
            
            
        }

        return answer;
    }
}
