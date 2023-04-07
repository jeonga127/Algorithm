def solution(board):
    n = len(board[0])
    answer = n ** 2
    s = set()
    
    for i in range(0, n) :
        for j in range(0, n):
            if board[i][j] == 1 : 
                if i != 0 and j != 0: s.add(str(i-1)+str(j-1))
                if i != 0 : s.add(str(i-1)+str(j))
                if i != 0 and j+1 != n : s.add(str(i-1)+str(j+1))
                if j != 0 : s.add(str(i)+str(j-1))
                s.add(str(i)+str(j))
                if j+1 != n : s.add(str(i)+str(j+1))
                if i+1 != n and j !=0 : s.add(str(i+1)+str(j-1))
                if i+1 != n : s.add(str(i+1)+str(j))
                if i+1 != n and j+1 !=n : s.add(str(i+1)+str(j+1))
    
    answer -= len(s)
    return answer