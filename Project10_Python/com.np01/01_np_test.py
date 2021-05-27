import numpy as np

lst = [1, 2, 3]
print(lst)
print(type(lst))

print('----------')

# numpy 행렬
a = np.array([1, 2, 3])
print(a)
print(type(a))
print(a.shape)
print(a[1])

print('----------')

b = np.array([[1, 2, 3], [4, 5, 6]])
print(b)
print(b.shape)
print(b[0][1])
print(b[0, 1])

print('----------')

# 0으로 채워진 행렬
zero01 = np.zeros((2, 3))
print(zero01)

# 1로 채워진 행렬
one = np.ones((3, 2))
print(one)
print(type(one))

print('----------')

arng01 = np.arange(10)
print(arng01)
print(type(arng01))

c = np.array([1, 2, 3])
print(c.shape)
d = np.array([[1, 2, 3]])
print(d.shape)
print(d)

print('----------')

# 행렬 연산
e = np.array([1, 2, 3])
f = np.array([[4, 5, 6]])
print(e + f)

print('----------')

g = np.array([[1, 2, 3], [4, 5, 6]])
h = np.array([[7, 8, 9], [0, 1, 2]])
print(g + h)

print('----------')

print(f.shape)
print(g.shape)

print(f + g)

print('----------')
print(g * h)
print(f * g)

print('----------')

i = np.array([[1, 3], [5, 7], [9, 1]])
print(i)
print(i.shape)

# (2, 3) * (3, 2) = (2, 2)
j = np.dot(g, i)
print(j)
print(j.shape)

print('----------')

j_max = np.max(j)
j_min = np.min(j)
j_mean = np.mean(j)
print('최대값:{} \t 최소값:{} \t 평균:{}'.format(j_max, j_min, j_mean))

# 단위 행렬 I
I = np.identity(3)
print(I)

# 역행렬
k = np.array([[1, 2], [3, 4]])
l = np.linalg.inv(k)
print(k)
print(l)
print(np.dot(k, l))

print('----------')
rand01 = np.random.rand(2, 3)
print(rand01)

rand02 = np.random.randint(1, 10, (2, 3))
print(rand02)