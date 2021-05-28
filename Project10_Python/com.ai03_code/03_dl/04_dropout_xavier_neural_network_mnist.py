import tensorflow as tf
from tensorflow_core.examples.tutorials.mnist import input_data
import os

os.environ['KMP_DUPLICATE_LIB_OK']='True'

'''
추가

# tensorflow 그래프 초기화
tf.reset_default_graph()

keep_prob = tf.placeholder(dtype=tf.float32)

_layer1 = tf.nn.relu(tf.matmul(X, W1) + b1)
layer1 = tf.nn.dropout(_layer1, keep_prob=keep_prob)

 _, cost_val = sess.run([train, cost], feed_dict={X:batch_x, Y: batch_y, keep_prob: 0.5})

print('정확도: {}'.format(sess.run(accuracy, feed_dict={X:mnist.test.images, Y: mnist.test.labels, keep_prob: 1})))
'''


# data loading
mnist = input_data.read_data_sets('../data/mnist/', one_hot=True)

# tensorflow 그래프 초기화
tf.reset_default_graph()

# placeholder
X = tf.placeholder(shape=[None, 784], dtype=tf.float32)
Y = tf.placeholder(shape=[None, 10], dtype=tf.float32)
keep_prob = tf.placeholder(dtype=tf.float32)

# Weight & bias
W1 = tf.get_variable('weight1', shape=[784, 256], initializer=tf.contrib.layers.xavier_initializer())
b1 = tf.Variable(tf.random_normal([256]), name='bias1')
_layer1 = tf.nn.relu(tf.matmul(X, W1) + b1)
# dropout : training 시엔 0.5 ~ 0.7 값을 이용하고 testing 시엔 1의 값을 이용
layer1 = tf.nn.dropout(_layer1, keep_prob=keep_prob)

W2 = tf.get_variable('weight2', shape=[256, 256], initializer=tf.contrib.layers.xavier_initializer())
b2 = tf.Variable(tf.random_normal([256]), name='bias2')
layer2 = tf.nn.relu(tf.matmul(layer1, W2) + b2)

W3 = tf.get_variable('weight3', shape=[256, 10], initializer=tf.contrib.layers.xavier_initializer())
b3 = tf.Variable(tf.random_normal([10]), name='bias3')

# Hypothesis
logit = tf.matmul(layer2, W3) + b3
H = tf.nn.relu(logit)

# cost
cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=logit, labels=Y))

# train
train = tf.train.AdamOptimizer(learning_rate=0.001).minimize(cost)

# session
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 학습
num_of_epoch = 30
batch_size = 100

for step in range(num_of_epoch):
    total_iter = int(mnist.train.num_examples / batch_size)
    for i in range(total_iter):
        batch_x, batch_y = mnist.train.next_batch(batch_size)
        _, cost_val = sess.run([train, cost], feed_dict={X:batch_x, Y: batch_y, keep_prob: 0.5})
        if step % 3 == 0:
            print('cost: {}'.format(cost_val))

# accuracy
predict = tf.argmax(H, 1)
correct = tf.equal(predict, tf.argmax(Y, 1))
accuracy = tf.reduce_mean(tf.cast(correct, dtype=tf.float32))

# testing
print('정확도: {}'.format(sess.run(accuracy, feed_dict={X:mnist.test.images, Y: mnist.test.labels, keep_prob: 1})))
