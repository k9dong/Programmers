import heapq

def solution(scoville, K):
    heapq.heapify(scoville)  # 최소 힙 생성
    count = 0  # 섞은 횟수
    
    while scoville[0] < K:
        if len(scoville) < 2:
            return -1  # 두 개 이상을 섞을 수 없으면 -1 반환하기
        
        first = heapq.heappop(scoville)  # 가장 작은 음식
        second = heapq.heappop(scoville)  # 두 번째로 작은 음식
        new_scoville = first + (second * 2)  # 섞은 음식의 지수
        heapq.heappush(scoville, new_scoville)  # 다시 힙에 추가
        count += 1  # 횟수 증가
    
    return count
