def numdivisor(number):
    s = set()
    for i in range(1, int(number**(1/2)) + 1):
        if (number % i == 0):
            s.add(i)
            s.add(number/i)
    return len(s)

def solution(number, limit, power):
    answer = 0
    for n in range(1, number+1) : 
        tmp = numdivisor(n)
        if tmp <= limit : 
            answer += tmp
        else : 
            answer += power
    return answer