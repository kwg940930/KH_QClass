# -*- coding:utf-8 -*-

import pickle

score = {'name': 'kh', 'kor': 100, 'eng': 60, 'math': 75}
with open('test02.txt', 'wb') as file:
    pickle.dump(score, file)
    
'''
pickling : 객체 -> 파일
unpickling : 파일 -> 객체 
'''