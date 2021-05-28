import tensorflow as tf
import matplotlib.pyplot as plt
import numpy as np
from tensorflow_core.examples.tutorials.mnist import input_data
import os

os.environ['KMP_DUPLICATE_LIB_OK']='True'

'''
from tensorflow.examples.tutorials.mnist import input_data 로 보통 사용하는데
없으면 tensorflow_core로 확인하기
'''

# loading data_tmp
mnist = input_data.read_data_sets('../data/mnist', one_hot=True)

# placeholder
X = tf.placeholder(shape=[None, 784], dtype=tf.float32)
Y = tf.placeholder(shape=[None, 10], dtype=tf.float32)

# Weight & bias
W = tf.Variable(tf.random_normal([784, 10]), name='weight')
b = tf.Variable(tf.random_normal([10]), name='bias')

# hypothesis
logit = tf.matmul(X, W) + b
H = tf.nn.softmax(logit)

# cost
cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=logit, labels=Y))

# train
train = tf.train.GradientDescentOptimizer(learning_rate=0.1).minimize(cost)


# session
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 학습
train_epoch = 30
batch_size = 100

for step in range(train_epoch):
    num_of_iter = int(mnist.train.num_examples / batch_size)
    cost_val = 0
    for i in range(num_of_iter):
        batch_x, batch_y = mnist.train.next_batch(batch_size)
        _, cost_val = sess.run([train, cost], feed_dict={X: batch_x, Y: batch_y})
    if step % 3 == 0:
        print('Cost: {}'.format(cost_val))

# accuracy
predict = tf.argmax(H, 1)
correct = tf.equal(predict, tf.argmax(Y, 1))
accuracy = tf.reduce_mean(tf.cast(correct, dtype=tf.float32))

print('정확도: {}'.format(sess.run(accuracy, feed_dict={X: mnist.test.images, Y: mnist.test.labels})))

r = np.random.randint(0, mnist.test.num_examples)
print('label: {}'.format(sess.run(tf.argmax(mnist.test.labels[r: r+1], 1))))
print('prediction: {}'.format(sess.run(tf.argmax(H, 1), feed_dict={X: mnist.test.images[r: r+1]})))

plt.imshow(mnist.test.images[r: r+1].reshape(28, 28), cmap='Greys', interpolation='nearest')
plt.show()
