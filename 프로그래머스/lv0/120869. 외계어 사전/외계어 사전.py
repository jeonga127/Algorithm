def solution(spell, dic):
    for d in dic:
        tmp = set(spell)-set(d)
        print(tmp)
        if len(tmp) == 0 :
            return 1
    return 2