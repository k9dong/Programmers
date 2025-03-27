def solution(brown, yellow):
    #전체 넓이
    s = brown + yellow
    
    answer = [0] *2
    
    #가로를 x로
    for x in range(3, s):
        
        # 나머지가 0이 아닐 경우 다음 넘어감
        if s % x != 0:
            continue
        
        y = s / x
        
        if y > x:
            continue
        
        if (x - 2) * (y - 2) == yellow:
            answer[0] = x
            answer[1] = y
            
            return answer
