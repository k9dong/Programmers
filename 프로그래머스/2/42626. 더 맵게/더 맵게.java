import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        
         for (int s : scoville) {
            minHeap.add(s); // 또는 offer(s)
        }
        
        while (minHeap.peek() < K && minHeap.size() >= 2 ){ // 크니까~
            
            int first = minHeap.poll();
            int second = minHeap.poll();
            int sum = first + (second * 2);
            count += 1;
            minHeap.add(sum);
        }
        if (minHeap.peek() < K) return -1;
        
        return count;
    }
}