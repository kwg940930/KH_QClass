import tensorflow as tf
from tensorflow_core.examples.tutorials.mnist import input_data
import os

os.environ['KMP_DUPLICATE_LIB_OK']='True'

# data loading
mnist = input_data.read_data_sets('../data/mnist/', one_hot=True)

# placeholder
X = tf.placeholder(shape=[None, 784], dtype=tf.float32)
Y = tf.placeholder(shape=[None, 10], dtype=tf.float32)

# Weight & bias
W1 = tf.Variable(tf.random_normal([784, 256]), name='weight1')
b1 = tf.Variable(tf.random_normal([256]), name='bias1')
# sigmoid 보다 성능이 좋은 relu 사용
layer1 = tf.nn.relu(tf.matmul(X, W1) + b1)

W2 = tf.Variable(tf.random_normal([256, 256]), name='weight2')
b2 = tf.Variable(tf.random_normal([256]), name='bias2')
layer2 = tf.nn.relu(tf.matmul(layer1, W2) + b2)

W3 = tf.Variable(tf.random_normal([256, 10]), name='weight3')
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
        _, cost_val = sess.run([train, cost], feed_dict={X:batch_x, Y: batch_y})
        if step % 3 == 0:
            print('cost: {}'.format(cost_val))

# accuracy
predict = tf.argmax(H, 1)
correct = tf.equal(predict, tf.argmax(Y, 1))
accuracy = tf.reduce_mean(tf.cast(correct, dtype=tf.float32))

print('정확도: {}'.format(sess.run(accuracy, feed_dict={X:mnist.test.images, Y: mnist.test.labels})))
