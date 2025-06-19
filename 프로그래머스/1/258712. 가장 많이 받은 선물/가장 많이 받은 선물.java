import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 선물 주고받은 기록
        Map<String, Map<String, Integer>> giftRecords = new HashMap<>();
        // 선물 지수 = 준 선물 - 받은 선물
        Map<String, Integer> giftScore = new HashMap<>();
        // 다음 달 받을 선물 수
        Map<String, Integer> nextMonthGifts = new HashMap<>();

        // 초기화
        for (String friend : friends) {
            giftRecords.put(friend, new HashMap<>());
            giftScore.put(friend, 0);
            nextMonthGifts.put(friend, 0);
        }

        // 선물 주고받기 기록 및 지수 계산
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            // 기록 저장
            Map<String, Integer> giverMap = giftRecords.get(giver);
            giverMap.put(receiver, giverMap.getOrDefault(receiver, 0) + 1);

            // 선물 지수 계산
            giftScore.put(giver, giftScore.get(giver) + 1);
            giftScore.put(receiver, giftScore.get(receiver) - 1);
        }

        // 다음 달 선물 받을 횟수 계산
        for (String giver : friends) {
            for (String receiver : friends) {
                if (giver.equals(receiver)) continue;

                int given = giftRecords.get(giver).getOrDefault(receiver, 0);
                int received = giftRecords.get(receiver).getOrDefault(giver, 0);

                if (given > received) {
                    nextMonthGifts.put(giver, nextMonthGifts.get(giver) + 1);
                } else if (given == received && giftScore.get(giver) > giftScore.get(receiver)) {
                    nextMonthGifts.put(giver, nextMonthGifts.get(giver) + 1);
                }
            }
        }

        // 가장 많이 받은 선물 수
        return Collections.max(nextMonthGifts.values());
    }
}
