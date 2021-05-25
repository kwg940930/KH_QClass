import tensorflow as tf

# 1. training data (학습 데이터셋)
# x = [1, 2, 3, 4, 5]
x = tf.placeholder(tf.float32)
# label (정답)
# y = [1, 2, 3, 4, 5]
y = tf.placeholder(tf.float32)

# 2. Weight & bias : 학습이 진행될수록(반복될수록) 변한다.
W = tf.Variable(tf.random_normal([1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')

# 3. Hypothesis (가설) : 최종 model
H = W * x + b

# 4. loss(cost) function
# 가설에서 정답을 뺴서 제곱한 값들을 모두 더해서 평균을 낸 그래프
loss = tf.reduce_mean(tf.square(H - y))

# 5. loss함수의 값을 최소화하는 W와 b를 구하자.
optimizer = tf.train.GradientDescentOptimizer(0.01)
train = optimizer.minimize(loss)

# 6. session 생성 및 초기화
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 7. 학습
epochs = 3000
for step in range(epochs):
    tmp, loss_val, W_val, b_val = sess.run([train, loss, W, b], feed_dict={x: [1, 2, 3, 4, 5], y: [1, 2, 3, 4, 5]})
    if step % 300 == 0:
        print('W:{} \t b:{} \t loss:{}'.format(W_val, b_val, loss_val))

# 8. prediction
print(sess.run(H, feed_dict={x: [6, 7, 8, 9, 10]}))