import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0; //제일 낮은 점수가 정가일 낮은 점수가 정가
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        for (int s : score) maxHeap.add(s);
        while (maxHeap.size() >= m) {
            int min = 999;
        for (int i=0; i<m; i++){
            int num = maxHeap.poll();
            if (min > num){
                min = num;
            }
        } answer += min * m;
            }
        return answer;
    }
}