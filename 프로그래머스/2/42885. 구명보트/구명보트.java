import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count =0;
        while (left <= right){ // 왜 <=이지
            if (people[left] + people[right] <= limit){
                left ++;
            }
            right--;
            count ++;
        }
        return count;
    }
}