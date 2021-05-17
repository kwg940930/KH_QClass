def fibo01(n):
    a, b = 0, 1
    i = 0
    while i < n:
        print(a, end=' ')
        a, b = b, a+b
        i += 1
    print()
        
        
def fibo02(n):
    res = list()
    a, b = 0, 1
    i = 0
    while i < n:
        res.append(a)
        a, b = b, a+b
        i += 1
    return res


if __name__ == '__main__':
    n = int(input('level : '))
    fibo01(n)
    print(fibo02(n))