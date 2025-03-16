def time_to_seconds(time_str):
    """mm:ss 형식의 시간을 초 단위로 변환"""
    mm, ss = map(int, time_str.split(":"))
    return mm * 60 + ss

def seconds_to_time(seconds):
    """초 단위를 mm:ss 형식의 문자열로 변환"""
    mm = seconds // 60
    ss = seconds % 60
    return f"{mm:02}:{ss:02}"

def solution(video_len, pos, op_start, op_end, commands):
    video_len_sec = time_to_seconds(video_len)
    pos_sec = time_to_seconds(pos)
    op_start_sec = time_to_seconds(op_start)
    op_end_sec = time_to_seconds(op_end)

    for command in commands:
        
        if op_start_sec <= pos_sec <= op_end_sec:
            pos_sec = op_end_sec
        
        if command == "prev":
            
            pos_sec = max(0, pos_sec - 10)
        elif command == "next":
            
            pos_sec = min(video_len_sec, pos_sec + 10)

        
        if op_start_sec <= pos_sec <= op_end_sec:
            pos_sec = op_end_sec

    return seconds_to_time(pos_sec)