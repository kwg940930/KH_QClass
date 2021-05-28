import tensorflow as tf

# dtype=np.float64 와 dtype=tf.float64는 같다. (tf 내부적으로 np 사용)
node1 = tf.constant(10, dtype=tf.float32)
node2 = tf.constant(20, dtype=tf.float32)
# node1과 node2의 data_tmp(tensor)를 가지고 와서 +연산을 해주는 node3 그래프
node3 = node1 + node2
sess = tf.Session()

# node3을 실행시키려면, node1과 node2가 먼저 수행되어야 한다.
# 자동적으로 node1, node2가 먼저 수행된 후에 node3이 실행됨.
print(sess.run(node3))

# 만일 node1과 node3을 같이 실행시키고 싶은 경우
print(sess.run([node1, node3]))
