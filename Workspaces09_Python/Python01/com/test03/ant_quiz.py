# 개미수열

def ant(i):
    inp = str(i)
    cnt = 0
    target = inp[0]
    res = ''
    
    for a in inp:
        if a == target:
            cnt += 1
        else:
            res += target + str(cnt)
            cnt = 1
            target = a
    res += target + str(cnt)
    
    return res

if __name__ == '__main__':
    n = input('ant stage : ')
    print('1')
    
    val = ant(1)
    print(val)
    
    for i in range(1, int(n)):
        val = ant(val)
        print(val)