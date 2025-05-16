import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] boxed = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, Collections.reverseOrder());
        int p = 0; // 최소가격 
        int count = score.length;
        int lee = m;
        
        for (int i= 0; i < score.length ; i++){
            
            if (boxed[i]<=k){
                p = boxed[i]; // p에는 한상자안의 제일 작은 가격이 담겨있다
            } lee--; // m 카운트용
            if (lee ==0){
                answer += p * m;
                p = 0;
                lee = m;
            }
            
        }
        return answer;
    }
}