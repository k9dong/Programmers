def solution(answers):
    pattern1 = [1, 2, 3, 4, 5] #5
    pattern2 = [2, 1, 2, 3, 2, 4, 2, 5] #8
    pattern3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] #10

    # 각 수포자의 점수판
    score = [0, 0, 0]

    
    for i, a in enumerate(answers):
        if a == pattern1[i % len(pattern1)]:
            score[0] += 1
        if a == pattern2[i % len(pattern2)]:
            score[1] += 1
        if a == pattern3[i % len(pattern3)]:
            score[2] += 1

    # 최고 점수 
    max_score = max(score)

    # 정답 배열 반환하기 (동점자 처리)
    answer = []
    for i in range(len(score)):
        if score[i] == max_score:
            answer.append(i + 1)
    return answer