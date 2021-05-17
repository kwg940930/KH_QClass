# import math
# math module에서 pi만 가지고 오겠다.
# (math.)pi
from math import pi


def circle(x):
    return pi * x * x


if __name__ == '__main__':
    r = input('원의 반지름 : ')
    print('반지름이 %s 인 원의 넓이는 %f 입니다.'%(r, circle(int(r))))