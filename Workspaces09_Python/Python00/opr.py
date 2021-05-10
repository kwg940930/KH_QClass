# 산술연산
a = 21
b = 2
print(a + b)
print(a - b)
print(a * b)
print(a ** b)   # a의 b승
print(a / b)
print(a // b)   # 몫 (floor division)
print(a % b)

# 비교연산
a, b = 5, 3
print(a == b)
print(a != b)
print(a > b)
print(a >= b)
print(a is b)
print(a is not b)

# 범위연산
list01 = list(range(100))   # 0 ~ 99
print(list01)

# [start: end] -> start ~ end-1
# [start: end: step] -> start ~ end-1까지 step만큼씩
print(list01[12: 50])
print(list01[12: 49: 3])

start01 = 'Hello World!'
# H 출력
print(start01[0])
# Hello 출력
print(start01[0:5])
# World 출력
print(start01[6:11])
# World! 출력
print(start01[6: ])

# ! 출력
print(start01[-1])
print(start01[-1: ])

print(start01[: -1])
print(start01[:: -1])



# in, not in
start02 = [1, 2, 3, 4, 5, 6]
print(3 in start02)
print(6 not in start02)
print(9 not in start02)

