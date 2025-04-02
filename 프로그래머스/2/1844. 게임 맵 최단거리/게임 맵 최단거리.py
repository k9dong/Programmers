from collections import deque

def solution(maps):
    queue = deque()
    
    height = len(maps) # 세로
    width = len(maps[0]) # 가로

    # 북 남 동 서 이동 좌표
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
        
    queue.append((0, 0))
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            # 범위 체크
            if nx < 0 or nx >= height or ny < 0 or ny >= width:
                continue
                
            # 벽(0)인지 확인
            if maps[nx][ny] == 0:
                continue
                
            # 방문 가능한 길(1)이라면 거리 계산
            if maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                queue.append((nx, ny))
    
    # 최종 목적지에 도달 못했다면 -1 반환
    return maps[height-1][width-1] if maps[height-1][width-1] != 1 else -1
