# list

# 생성자
a = list()
print(a)
a.append(1)
print(a)
a.append('one')
print(a)
a[1] = 'two'
print(a)

# a[2] = 3
# print(a)

# [] 사용
b = [1, 2, 3, 4, 5]
print(b)

print(b[0] + b[4])

b.reverse()
print(b)

b.sort()
print(b)

# 중첩
c = ['a', 'b', 'c', ['d', 'e', 'f']]
print(c)

print(c[3][2])


print(b + c)
