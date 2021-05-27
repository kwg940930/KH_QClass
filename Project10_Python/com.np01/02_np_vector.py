import numpy as np


a = np.array([[1, 2]])
b = np.array([[3], [4]])

# 백터의 내적
# 행렬 곱으로도 사용
print(a.dot(b))

#전치행렬
print(a)
print(a.shape)
a_t = a.T
print(a_t)
print(a_t.shape)

# 절대값
print(np.linalg.norm(a))

# sigma
# 1 ~ 100까지 다 더하고 싶다.
# [1 1 1 1 ... 1] * [[1],[2],[3],...,[100]]
c = np.ones(100)
print(c)
d = np.arange(1, 101)
print(c.dot(d))