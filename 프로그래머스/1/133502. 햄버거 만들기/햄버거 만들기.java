import java.util.*;

class Solution { 
    // 1은 빵, 2는 야채, 3은 고기 1-2-3-1 가 하나의 세트
    public int solution(int[] ingredient) {
        int answer = 0;
        Integer[] karr = Arrays.stream(ingredient).boxed().toArray(Integer[]::new);
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(karr)); 
        int i = 0;
        while (i <= arr.size() - 4) { // 4칸을 봐야 하니 <= size-4
            if(arr.get(i) == 1 && arr.get(i+1) == 2 && arr.get(i+2) == 3 && arr.get(i+3) == 1 ){
                arr.subList(i, i+4).clear();
                answer++;
                i = Math.max(0, i - 3); // 겹침 방지용
            } else {
                i++;
            }
        }
        return answer;
    }
}
