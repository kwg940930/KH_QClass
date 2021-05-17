# -*- coding:utf-8 -*-

file = open('test01.txt', 'w')
file.write('Hello, world!')
file.close()

'''
r : 읽기
w : 쓰기 (기존 내용 덮어쓰기)
a ; 쓰기 (기존 내용 이어서 쓰기)
x : 새로운 파일 만들어서 쓰기 (이미 파일이 있으면 에러)
t / b : test / binary (deault : t)
'''