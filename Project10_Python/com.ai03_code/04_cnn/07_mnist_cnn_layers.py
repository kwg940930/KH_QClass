import tensorflow as tf
from tensorflow_core.examples.tutorials.mnist import input_data

import os

os.environ['KMP_DUPLICATE_LIB_OK']='True'

tf.reset_default_graph()

# 1. data loading
mnist = input_data.read_data_sets('../data/mnist/', one_hot=True)

# 2. placeholder
X = tf.placeholder(shape=[None, 784], dtype=tf.float32)
Y = tf.placeholder(shape=[None, 10], dtype=tf.float32)

keep_prob = tf.placeholder(dtype=tf.float32)
# convolution
# conv layer 1
# convolution image 처리 형태로 변환
x_img = tf.reshape(X, [-1, 28, 28, 1])
# W1 = tf.Variable(tf.random_normal([3, 3, 1, 32], stddev=0.01))
# L1 = tf.nn.conv2d(x_img, W1, strides=[1, 1, 1, 1], padding='SAME')
# L1 = tf.nn.relu(L1)
# L1 = tf.nn.max_pool(L1, ksize=[1, 2, 2, 1], strides=[1, 2, 2, 1], padding='SAME')
L1 = tf.layers.conv2d(inputs=x_img, filters=32, kernel_size=[3, 3], padding='SAME', strides=1, activation=tf.nn.relu)
L1 = tf.layers.max_pooling2d(inputs=L1, pool_size=[2, 2], padding='SAME', strides=2)
L1 = tf.layers.dropout(inputs=L1, rate=keep_prob)

print('L1 shape: {}'.format(L1.shape))

# conv layer 2
W2 = tf.Variable(tf.random_normal([3, 3, 32, 64], stddev=0.01))
L2 = tf.nn.conv2d(L1, W2, strides=[1, 1, 1, 1], padding='SAME')
L2 = tf.nn.relu(L2)
L2 = tf.nn.max_pool(L2, ksize=[1, 2, 2, 1], strides=[1, 2, 2, 1], padding='SAME')
print('L2 shape: {}'.format(L2.shape))

# FC에 넣기 위해서 flatten 처리
L2 = tf.reshape(L2, [-1, 7*7*64])
print('L2 shape: {}'.format(L2.shape))

# Weight & bias
W3 = tf.get_variable('weight3', shape=[7*7*64, 256], initializer=tf.contrib.layers.xavier_initializer())
b1 = tf.Variable(tf.random_normal([256]), name='bias1')
_layer1 = tf.nn.relu(tf.matmul(L2, W3) + b1)
layer1 = tf.nn.dropout(_layer1, keep_prob=keep_prob)

W4 = tf.get_variable('weight4', shape=[256, 256], initializer=tf.contrib.layers.xavier_initializer())
b2 = tf.Variable(tf.random_normal([256]), name='bias2')
_layer2 = tf.nn.relu(tf.matmul(layer1, W4) + b2)
layer2 = tf.nn.dropout(_layer2, keep_prob=keep_prob)

W5 = tf.get_variable('weight5', shape=[256, 10], initializer=tf.contrib.layers.xavier_initializer())
b3 = tf.Variable(tf.random_normal([10]), name='bias3')

# Hypothesis
H = tf.matmul(layer2, W5) + b3

# cost function
cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=H, labels=Y))

# train
train = tf.train.AdamOptimizer(learning_rate=0.001).minimize(cost)

# session
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 학습
num_of_epoch = 5
batch_size = 100

for step in range(num_of_epoch):
    num_of_iter = int(mnist.train.num_examples / batch_size)
    avg_cost = 0
    for i in range(num_of_iter):
        batch_x, batch_y = mnist.train.next_batch(batch_size)
        _, cost_val = sess.run([train, cost], feed_dict={X: batch_x, Y: batch_y, keep_prob: 0.7})
        avg_cost += cost_val / num_of_iter
    print('cost: {}'.format(avg_cost))

# accuracy
predict = tf.argmax(H, 1)
correct = tf.equal(predict, tf.argmax(Y, 1))
accuracy = tf.reduce_mean(tf.cast(correct, dtype=tf.float32))

print('정확도: {}'.format(sess.run(accuracy, feed_dict={X: mnist.test.images, Y: mnist.test.labels, keep_prob: 1})))
