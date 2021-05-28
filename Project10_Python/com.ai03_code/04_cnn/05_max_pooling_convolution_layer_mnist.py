import tensorflow as tf
from tensorflow_core.examples.tutorials.mnist import input_data
import matplotlib.pyplot as plt
import numpy as np

import os

os.environ['KMP_DUPLICATE_LIB_OK']='True'

mnist = input_data.read_data_sets('../data/mnist/', one_hot=True)
img = mnist.train.images[0].reshape(28, 28)

# image 정보 reshape
img = img.reshape(-1, 28, 28, 1)
W = tf.Variable(tf.random_normal([3, 3, 1, 5]), name='weight')
conv2d = tf.nn.conv2d(img, W, strides=[1, 2, 2, 1], padding='SAME')
print('conv2d shape: {}'.format(conv2d.shape))

# max pooling
pool = tf.nn.max_pool(conv2d, ksize=[1, 2, 2, 1], strides=[1, 2, 2, 1], padding='SAME')
print('pool shape: {}'.format(pool.shape))

sess = tf.Session()
sess.run(tf.global_variables_initializer())
pool_img = sess.run(pool)

# 이미지 처리를 위한 axes 전환
pool_img = np.swapaxes(pool_img, 0, 3)
print('pool_img shape: {}'.format(pool_img.shape))

# 1행 5열짜리 subplot
fig, axes = plt.subplots(1, 5)

for idx, t_img in enumerate(pool_img):
    axes[idx].imshow(t_img.reshape(7, 7), cmap='Greys')

plt.show()
