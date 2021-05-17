def func01():
    print('함수 1 입니다')
    
    
def func02():
    return '함수 2 입니다.'


def func03():
    return{1: 'a', 2: 'b'}


# main함수 -> 프로그램의 주 진입점    
if __name__ == '__main__':
    print('프로그램 시작 시 가장 먼저 호출됨!')
    func01()
    print(func02())
    print(func03()[2])
