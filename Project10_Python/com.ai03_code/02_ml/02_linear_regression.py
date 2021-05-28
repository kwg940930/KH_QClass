import tensorflow as tf

# 1. training data_tmp set
x = tf.placeholder(tf.float32)
y = tf.placeholder(tf.float32)

# 2. Weight & bias
W = tf.Variable(tf.random_normal([1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')

# 3. Hypothesis
H = W * x + b

# 4. loss function
loss = tf.reduce_mean(tf.square(H - y))

# 5. gradient descent
optimizer = tf.train.GradientDescentOptimizer(0.01)
train = optimizer.minimize(loss)

# 6. session
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 7. learning
epochs = 5000
for step in range(epochs):
    tmp, loss_val, W_val, b_val = sess.run([train, loss, W, b], feed_dict={x: [1, 2, 3, 4], y: [3, 5, 7, 9]})
    if step % 500 == 0:
        print('W:{} \t b:{} \t loss:{} '.format(W_val, b_val, loss_val))

# 8. prediction
print(sess.run(H, feed_dict={x: [10, 11, 12, 13]}))
