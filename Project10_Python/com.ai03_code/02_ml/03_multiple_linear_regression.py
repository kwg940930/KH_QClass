import tensorflow as tf

# multiple(multi-variable) linear regression
# 1. training data_tmp set
x_data = [[73, 80, 75],
          [93, 88, 93],
          [89, 91, 90],
          [96, 89, 100],
          [73, 66, 70]]
y_data = [[152],
          [185],
          [180],
          [196],
          [142]]

# 1-1.placeholder
# 변수의 종류(quiz1, quiz2, quiz3)는 변하지 않겠지만, row의 갯수(학생 수)는 변할 수 있 다.
# shape=[5, 3] : 예측할 때도 5명 넣어서 예측해야 한다. #->shape=[None,3]->None:don'tcare(몇명이 들어오든 상관하지 않겠다.)
X = tf.placeholder(shape=[None, 3], dtype=tf.float32)
Y = tf.placeholder(shape=[None, 1], dtype=tf.float32)


# 2. Weight & bias
#W:3x1 로 만들어야 X와 행렬연산을 할 수 있다. #->X[None,3],Y[None,1]의 형태를 통해 정해진다.
W = tf.Variable(tf.random_normal([3, 1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')

# 3. Hypothesis (Prediction Model) # tf.matmul -> X * W 행렬연산
H = tf.matmul(X, W) + b

# 4. loss function
loss = tf.reduce_mean(tf.square(H - Y))

# 5. gradient descent
learning_rate = 0.000046
optimizer = tf.train.GradientDescentOptimizer(learning_rate)
train = optimizer.minimize(loss)

# 6. session
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 7. learning
epochs = 200000
for step in range(epochs):
    tmp, loss_val, W_val, b_val = sess.run([train, loss, W, b], feed_dict={X: x_data, Y: y_data})
    if step % 20000 == 0:
        print('W:{} \t b:{} \t loss:{} '.format(W_val, b_val, loss_val))

# 8. prediction
print(sess.run(H, feed_dict={X: [[100, 35, 87]]}))
