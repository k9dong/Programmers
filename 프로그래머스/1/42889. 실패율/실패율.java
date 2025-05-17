import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1) 스테이지별 실패자 수 집계 (1~N) 
        int[] failCount = new int[N + 2];  // 인덱스 N+1은 “모든 스테이지 클리어”용
        for (int s : stages) {
            if (s <= N) {
                failCount[s]++;
            }
        }

        // 2) 남은 도전자 수(remaining)를 단계별로 업데이트하며 실패율 계산
        int remaining = stages.length;
        List<Stage> list = new ArrayList<>();
        for (int stage = 1; stage <= N; stage++) {
            double rate = (remaining == 0) ? 0.0 : (double) failCount[stage] / remaining;
            list.add(new Stage(stage, rate));
            remaining -= failCount[stage];
        }

        // 3) 실패율 내림차순, 스테이지 오름차순 정렬
        Collections.sort(list, (a, b) -> {
            if (b.failRate != a.failRate) {
                return Double.compare(b.failRate, a.failRate);
            }
            return a.stageNum - b.stageNum;
        });

        // 4) 정렬된 순서대로 스테이지 번호만 뽑아 배열로 반환
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).stageNum;
        }
        return answer;
    }

    // 스테이지 번호와 실패율을 함께 담는 간단한 DTO
    private static class Stage {
        int stageNum;
        double failRate;
        Stage(int stageNum, double failRate) {
            this.stageNum = stageNum;
            this.failRate = failRate;
        }
    }
}
