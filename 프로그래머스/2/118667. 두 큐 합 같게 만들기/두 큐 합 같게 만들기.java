import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int count = 0;
        for (int q : queue1){
            q1.offer(q);
            sum1 +=q;
        }
        for (int q: queue2){
            q2.offer(q);
            sum2 += q;
        }
        
        while (sum1 != sum2){
            if (sum1 > sum2){
                int gap = q1.poll();
                sum1 -=gap;
                q2.offer(gap);
                sum2 += gap;
                count++;
                    
            }else{
                int gap2 = q2.poll();
                sum2 -= gap2;
                q1.offer(gap2);
                sum1 += gap2;
                count++;
            }
            if (count > (4*queue1.length) ) {
                return -1;
            }
        }
        return count;
    }
}