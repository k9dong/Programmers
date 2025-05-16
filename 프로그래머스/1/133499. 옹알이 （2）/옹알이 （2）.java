import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int count = 0; // 조카가 발음 가능한 단어 개수
        String[] words = {"aya", "ye", "woo", "ma"}; // 발음 가능한 단어 조각들

        for (String s : babbling) { // 각 단어마다 검사 시작
            String temp = s;  // 원본 문자열을 자르기 위한 복사본
            String prev = ""; // 직전에 발음한 단어 저장 (중복 방지용)
            boolean isValid = true; // 이 단어가 유효한 발음 조합인지 여부

            while (!temp.isEmpty()) { // temp가 빌 때까지 반복 (== 아직 남은 문자 있음)
                boolean matched = false; // 이번에 발음 가능한 조각이 있었는지 여부

                for (String word : words) { // 네 가지 발음 중 하나로 시작하는지 검사
                    if (temp.startsWith(word)) { 
                        // ✅ startsWith(String str)
                        // → 문자열이 'str'로 시작하는지 검사
                        // 예: "ayaye".startsWith("aya") → true

                        if (word.equals(prev)) { 
                            // 직전 발음과 동일하면 ❌ 탈락 조건
                            isValid = false;
                            break;
                        }

                        prev = word; // 현재 발음을 prev로 저장
                        temp = temp.substring(word.length());
                        // ✅ substring(int beginIndex)
                        // → 문자열을 beginIndex부터 끝까지 자름
                        // 예: "ayaye".substring(3) → "ye" (3번째 문자부터 끝까지)
                        // 예: "wooaya".substring(3) → "aya"

                        matched = true; // 발음 가능 조각 찾았음
                        continue; // 더 검사할 필요 없으므로 종료
                    }
                }

                if (!matched) {
                    // 어느 발음 조각으로도 시작하지 않으면 실패 처리
                    isValid = false;
                    break;
                }
            }

            if (isValid) count++; // 모든 조건 통과한 경우만 count 증가
        }

        return count;
    }
}
