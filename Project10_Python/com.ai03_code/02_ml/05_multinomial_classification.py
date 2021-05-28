import tensorflow as tf
import os

os.environ['KMP_DUPLICATE_LIB_OK']='True'
# OMP: Error #15: Initializing libiomp5.dylib, but found libiomp5.dylib already initialized.


# training data_tmp set
x_data = [[10, 7, 8, 5],
          [8, 8, 9, 4],
          [7, 8, 2, 3],
          [6, 3, 9, 3],
          [7, 5, 7, 4],
          [3, 5, 6, 2],
          [2, 4, 3, 1]]
y_data = [[1, 0, 0],
          [1, 0, 0],
          [0, 1, 0],
          [0, 1, 0],
          [0, 1, 0],
          [0, 0, 1],
          [0, 0, 1]]

# placeholder
X = tf.placeholder(shape=[None, 4], dtype=tf.float32)
Y = tf.placeholder(shape=[None, 3], dtype=tf.float32)

# Weight & bias
W = tf.Variable(tf.random_normal([4, 3]), name='weight')
b = tf.Variable(tf.random_normal([3]), name='b')

# Hypothesis
logits = tf.matmul(X, W) + b
H = tf.nn.softmax(logits)

# cost function
cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=logits, labels=Y))

# train
train = tf.train.GradientDescentOptimizer(learning_rate=0.01).minimize(cost)

# session
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 학습
for step in range(3000):
    _, cost_val = sess.run([train, cost], feed_dict={X: x_data, Y: y_data})
    if step % 300 == 0:
        print('Cost : {}'.format(cost_val))

# accuracy
# 두번째 인자는 one-hot encoding을 적용할 차원
predict = tf.argmax(H, 1)
correct = tf.equal(predict, tf.argmax(Y, 1))
accuracy = tf.reduce_mean(tf.cast(correct, dtype=tf.float32))

print('정확도 : {}'.format(sess.run(accuracy, feed_dict={X: x_data, Y: y_data})))
print(sess.run(H, feed_dict={X:[[9, 4, 3, 6]]}))
print(sess.run(predict, feed_dict={X:[[9, 4, 3, 6]]}))
