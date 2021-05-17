# lambda 파라미더 : 리턴될 값

hap01 = lambda a, b: a + b
print(hap01(10, 20))

gop = lambda a, b: a * b
print(gop(10, 20))

hap02 = lambda a, b, c: a + b + c
print(hap02(10, 20, 30))

a = [(1, 'one' , 9), (2, 'two', 8), (3, 'three', 7), (4, 'four', 6)]
a.sort(key=lambda a:a[2])
print(a)

# min01 = lambda x, y: x if x < y else y
# print(min01(11,22))
min01 = (lambda x, y: x if x < y else y)(11, 22)
print(min01)

max01 = (lambda x, y: x if x > y else y)(33, 44)
print(max01)



b = lambda x: (lambda newx: x + newx)
print(b(100)(90))

# c = lambda newx : 100 + newx
c = b(100)
#print(c(90))
print(c)
d = c(90)
print(d)

# 1 ~ 100 사이에서 5의 배수 출력
e = lambda x: bool(x % 5)
#print(e(9))
five = [i for i in range(1, 100) if not e(i)]
print(five)

# None = Null
f = lambda x: x if (x % 5 != 0) else None
res = [i for i in range(1, 100) if not f(i)]
print(res)

# 합쳐보자
result = [i for i in range(1, 100) if not (lambda x: x if (x % 5 != 0) else None)(i)]
print(result)