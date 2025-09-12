import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();  // 보조 컨베이어
        int answer = 0;                        // 실은 상자 수
        int box = 1;                           // 메인 컨베이어에서 나올 박스 번호
        
        for (int o : order) {
            // 메인 컨베이어에서 필요한 번호까지 Stack에 쌓기
            while (box <= o) {
                stack.push(box);
                box++;
            }
            
            // 이제 Stack의 top이 내가 원하는 박스인지 확인
            if (!stack.isEmpty() && stack.peek() == o) {
                stack.pop();
                answer++;
            } else {
                break;  // 더 이상 진행 불가
            }
        }
        
        return answer;
    }
}
