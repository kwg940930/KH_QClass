def func01(x, y):
    return x + y


def func02(x, y):
    return x + y, x - y


def print_test(x, y):
    print("파라미터로 %d, %d 두개가 들어왔습니다." % (x, y))
    print("{} + {} = {}".format(x, y, x + y))
    print(x,'+',y,'=',x+y)
    print(str(x) + ' + ' + str(y) + ' = ' + str(x+y))
    
    
if __name__ == '__main__':
    a = func01(1, 3)
    print(a)
    
    b, c = func02(4, 7)
    d = func02(5, 8)
    print(b)
    print(c)
    print(d)
    print_test(6, 3)
    