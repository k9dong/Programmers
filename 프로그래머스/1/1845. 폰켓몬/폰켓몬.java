import java.util.*;
class Solution {
    // 최대한 다양한 종류의 포켓몬
    public int solution(int[] nums) {
        int answer = nums.length;
        HashSet <Integer> set = new HashSet<>();
        for (int m : nums){
            set.add(m);
        }
        return Math.min(set.size(), answer/2);
    }
}