import numpy as np
import matplotlib.pyplot as plt

def test01():
    # data 만들기
    x = np.arange(10)
    np.random.seed(1)
    y = np.random.rand(10)

    plt.plot(x, y)
    plt.show()


def a(x):
    return 2 * x + 3


def b(x):
    return 2 * (x ** 2) + 3 * x + 4


def test02():
    x = np.linspace(-10, 10, 21)
    # lt.plot(x, a(x))
    plt.plot(x, b(x))
    plt.show()


def c(x, m, n):
    return (x ** 3) + m * (x ** 2) + n


def test03():
    x = np.linspace(-10, 10, 42)

    plt.plot(x, c(x, 3, 4), color='red', label='x^3 + 3x^2 + 4')
    plt.plot(x, c(x, 8, 0), color='blue', label='x^3 + 8x^2')

    plt.title('y = x^3 + mx^2 + n')

    plt.legend(loc='upper left')

    plt.xlabel('x')
    plt.ylabel('y')

    plt.ylim(-100, 100)

    plt.grid(True)

    plt.show()


def test04():
    plt.figure(figsize=(10, 3))
    x = np.linspace(-10, 10, 42)

    plt.subplot(1, 3, 1)
    plt.plot(x, a(x), color='red', label='a(x)')

    plt.subplot(1, 3, 2)
    plt.plot(x, b(x), color='green', label='b(x)')

    plt.subplot(1, 3, 3)
    plt.plot(x, c(x, 2, 3), color='blue', label='c(x)')

    plt.show()


def d(x1, x2):
    y = 2 * (x1 ** 2) + 3 * (x2 ** 2)
    # 지수함수로 만들어서, 곱해서 리턴
    return y * np.exp(-y)


def test05():
    x1 = np.linspace(-1, 1, 11)
    x2 = np.linspace(-1, 1, 11)

    y = np.zeros((len(x1), len(x2)))

    for i in range(len(x1)):
        for j in range(len(x2)):
            y[i, j] = d(x1[i], x2[j])

    print(np.round(y, 1))
    grayShow(y)
    surfaceShow(x1, x2, y)


def grayShow(y):
    plt.figure(figsize=(3.5, 3))
    plt.gray()
    plt.pcolor(y)
    plt.colorbar()
    plt.show()


def surfaceShow(x1, x2, y):
    m_x1, m_x2 = np.meshgrid(x1, x2)
    plt.figure(figsize=(5, 3.5))

    ax = plt.subplot(1, 1, 1, projection='3d')

    ax.plot_surface(m_x1, m_x2, y, rstride=1, cstride=1, alpha=0.3, color='blue', edgecolor='black')
    ax.set_zticks((0, 0.5))

    ax.view_init(50, -70)
    plt.show()


if __name__ == '__main__':
    # test01()
    # test02()
    # test03()
    # test04()
    test05()
