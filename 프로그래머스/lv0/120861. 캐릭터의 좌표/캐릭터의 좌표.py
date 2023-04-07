def solution(keyinput, board):
    answer = [0,0]
    x_limit = (board[0]-1) /2
    y_limit = (board[1]-1) /2
    
    for k in keyinput : 
        if k == "left" :
            if answer[0] > -(x_limit) :
                answer[0] -= 1
        elif k == "right" :
            if answer[0] < x_limit :
                answer[0] += 1
        elif k == "up" :
            if answer[1] <  y_limit :
                answer[1] += 1
        elif k == "down" :
            if answer[1] > -(y_limit) :
                answer[1] -= 1
                
    return answer