import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 문자열 사전 순 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            // 정렬했기 때문에 바로 다음 번호만 보면 됨
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
