# pip install numpy         -> 수치해석
# pip install matplotlib    -> 그래프(시각화)

# import <module_name> as <alias>
import numpy as np
import matplotlib.pyplot as plt
import random

def plt01():
    x = np.arange(0, 11)
    y = x
    # print(x)
    
    plt.plot(x, y)
    
    plt.xlabel('x')
    plt.ylabel('y')
    
    # 범례
    plt.legend(['y=x'])
    
    plt.show()


plt01()