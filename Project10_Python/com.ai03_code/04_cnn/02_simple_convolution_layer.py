import tensorflow as tf
import numpy as np

# (1, 3, 3, 1) -> (이미지 갯수, width, height, color)
image = np.array([
    [
        [[1], [2], [3]],
        [[4], [5], [6]],
        [[7], [8], [9]]
    ]
], dtype=np.float32)

# (2, 2, 1, 3) -> (width, height, color, filter 갯수)
weight = np.array([
    [
        [[1, 10, -1]],
        [[1, 10, -1]]
    ],
    [
        [[1, 10, -1]],
        [[1, 10, -1]]
    ]
], dtype=np.float32)

print('image shape: {}'.format(image.shape))
print('weight shape: {}'.format(weight.shape))

# strides (1, 1, 1, 1) -> (1, stride 가로, stride 세로, 1)
conv2d = tf.nn.conv2d(image, weight, strides=[1, 1, 1, 1], padding='VALID')
print('convolution shape: {}'.format(conv2d.shape))

sess = tf.Session()
print(sess.run(conv2d))

