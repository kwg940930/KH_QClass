# dictionary : {}

# 생성자
dict01 = dict()
dict01[1] = 1
dict01[2] = 2
print(dict01)

# {} 사용
dict02 = {}
dict02['one'] = 1
dict02['2'] = 'this is two'
dict02[3] = 3
print(dict02)

dict02[3] = 1
print(dict02)


# key / value 가져오기
print(dict01.get(1))
print(dict02.get('one'))
print(dict02['one'])

print(dict02.keys())
print(dict02.values())

print(list(dict02.values())[1])
