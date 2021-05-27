import numpy as np
import matplotlib.pyplot as plt


def test01():
    # 지수함수
    x = np.linspace(-5, 5, 100)
    y1 = 2 ** x
    y2 = 4 ** x
    y3 = 0.5 ** x
    y4 = 0.25 ** x

    plt.figure(figsize=(5,5))
    plt.plot(x, y1, 'red', linewidth=3, label='y=2^x')
    plt.plot(x, y2, 'green', linewidth=3, label='y=4^x')
    plt.plot(x, y3, 'blue', linewidth=3, label='y=0.5^x')
    plt.plot(x, y4, 'black', linewidth=3, label='y=0.25^x')

    plt.xlim(-4, 4)
    plt.ylim(-2, 6)
    plt.grid(True)
    plt.legend(loc='lower right')
    plt.show()


def test02():
    # 로그함수
    x = np.linspace(0.001, 10, 100)
    y = np.log(x) / np.log(2)

    plt.figure(figsize=(5, 5))
    plt.plot(x, y, 'black', linewidth=3)

    plt.xlim(-2, 5)
    plt.ylim(-10, 10)
    plt.grid(True)
    plt.show()


def test03():
    # 지수, 로그
    x = np.linspace(-5, 5, 100)
    y1 = 2 ** x
    y2 = np.log(x) / np.log(2)

    plt.figure(figsize=(5,5))
    plt.plot(x, y1, 'red', linewidth=3)
    plt.plot(x, y2, 'blue', linewidth=3)
    plt.plot(x, x, 'black', linewidth=1, linestyle='--')

    plt.xlim(-5, 5)
    plt.ylim(-5, 5)
    plt.grid(True)
    plt.show()


def test04():
    # 지수함수 미분
    x = np.linspace(-5, 5, 100)
    y = 2 ** x
    dy = np.log(2) * y

    plt.plot(x, y, 'red', linestyle='--', linewidth=3, label='y')
    plt.plot(x, dy, 'blue', linewidth=3, label='dy')

    plt.xlim(-5, 5)
    plt.ylim(-1, 10)
    plt.grid(True)
    plt.legend(loc='lower right')
    plt.show()


def test05():
    # 로그함수 미분
    x = np.linspace(0.0001, 5, 100)
    y = np.log(x)
    dy = 1 / x

    plt.plot(x, y, 'red', linestyle='--', linewidth=3, label='y')
    plt.plot(x, dy, 'blue', linewidth=3, label='dy')

    plt.xlim(-1, 5)
    plt.ylim(-10, 10)
    plt.grid(True)
    plt.legend(loc='lower right')
    plt.show()


if __name__ == '__main__':
    # test01()
    # test02()
    # test03()
    # test04()
    test05()