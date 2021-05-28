import tensorflow as tf

# conda install tensorflow=1.15 -y
# print(tf.__version__)

# 상수 노드 (100 이라는 값을 가진 노드)
node = tf.constant(100)

# session : 그래프를 실행시켜주는 역할. (runner)
sess = tf.Session()
# node를 실행
print(sess.run(node))
