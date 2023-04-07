def solution(common):
    answer = 0
    
    if common[2]-common[1] == common[1]-common[0]: 
        answer = common[len(common)-1] + (common[1]-common[0])
    
    elif common[2]/common[1] == common[1]/common[0]: 
        answer = common[len(common)-1] * (common[1]/common[0])
    
    return answer