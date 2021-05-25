# conda install tensorflow=1.15 -y
# tensor 2.X 버전은 숨겨져있음..! 함수 몇개 있으면 다됨, 내부적으로 어떻게 동작하는지 보기 위해 1버전 설치
import tensorflow as tf

# print(tf.__version__)

# 상수노드
node = tf.constant(100)

# session : 그래프를 실행시켜주는 역할
sess = tf.Session()

# 실행
print(sess.run(node))