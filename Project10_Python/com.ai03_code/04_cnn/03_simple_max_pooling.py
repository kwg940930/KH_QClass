import tensorflow as tf
import numpy as np

# (1, 2, 2, 1) -> (이미지 갯수, width, height, color)
image = np.array([
    [
        [[4], [3]],
        [[2], [1]]
    ]
], dtype=np.float32)

print('image shape: {}'.format(image.shape))
# ksize = pooling의 filter 크기
pool = tf.nn.max_pool(image, ksize=[1, 2, 2, 1], strides=[1, 1, 1, 1], padding='SAME')
print('pool shape: {}'.format(pool.shape))

sess = tf.Session()
print(sess.run(pool))
