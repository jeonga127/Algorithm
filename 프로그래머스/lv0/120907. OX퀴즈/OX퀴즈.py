def solution(quiz):
    answer = []
    temp = []
    
    for s in quiz :
        temp.append(s.split(" "))
        print(temp)
        
    for i in temp:
        if i[1] == '+':
            if int(i[0]) + int(i[2]) == int(i[4]):
                answer.append("O")
            else:
                answer.append("X")
        if i[1] == '-':
            if int(i[0]) - int(i[2]) == int(i[4]):
                answer.append("O")
            else:
                answer.append("X")
    return answer