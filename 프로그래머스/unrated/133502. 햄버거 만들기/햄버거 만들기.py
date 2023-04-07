def solution(ingredient):
    answer = 0
    arr = []
    for i in ingredient :
        arr.append(i)
        if len(arr) >= 4 :
            if arr[-4:] == [1,2,3,1] :
                arr.pop()
                arr.pop()
                arr.pop()
                arr.pop()
                answer += 1
        
    return answer