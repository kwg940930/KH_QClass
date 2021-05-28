import tensorflow as tf

# logistic regression
# 1. training data_tmp set
#[1,0]:1시간 공부했고,0일 연수다녀옴 /[0]:fail
#[8,1]:8시간 공부했고,1일 연수다녀옴 /[1]:pass

x_data = [[1, 0],
          [2, 0],
          [5, 1],
          [2, 3],
          [3, 3],
          [8, 1],
          [10, 0]]
y_data = [[0],
          [0],
          [0],
          [0],
          [1],
          [1],
          [1]]

# 1-1. placeholder
X = tf.placeholder(shape=[None, 2], dtype=tf.float32)
Y = tf.placeholder(shape=[None, 1], dtype=tf.float32)

# 2. Weight & bias
W = tf.Variable(tf.random_normal([2, 1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')

# 3. Hypothesis (Model)
logit = tf.matmul(X, W) + b
# 0~1 사이의 실수 (H>0.5:True)
H = tf.sigmoid(logit)

# 4. loss function
# loss function 이 이차함수 기준으로
# loss = tf.reduce_mean(tf.square(H - Y))
# 지금은 cost function 이 고차함수 -> 미분했을 때 값이 0인 지점이 1개가 아니다.
# convex function 으로 바꿔줘야 한다.
# cross_entropy == loss
loss = tf.reduce_mean(tf.nn.sigmoid_cross_entropy_with_logits(logits=logit, labels=Y))

# 5. gradient descent
learning_rate = 0.1
optimizer = tf.train.GradientDescentOptimizer(learning_rate)
train = optimizer.minimize(loss)

# 6. session
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 7. learning
epochs = 100000
for step in range(epochs):
    tmp, loss_val, W_val, b_val = sess.run([train, loss, W, b], feed_dict={X: x_data, Y: y_data})
    if step % 500 == 0:
        print('W:{} \t b:{} \t loss:{} '.format(W_val, b_val, loss_val))

# logistic 부터는 model 의 정확도를 측정 -> 97% 이상 (가능한 99%) 이어야 사용 가능 # 여러가지 지표를 이용하여 측정 필요!
# accuracy 를 이용해서 정확도 측정 (ex. 100개 중 70개를 맞춤 = 70%)
# 학습데이터로 모델을 평가한다면 정확한 평가를 할 수 없음
# 일반적으로 training data_tmp set 을 7:3 or 8:2 비율로 사용

#(H>0.5)의 결과값 TrueorFalse 를 0.or1. 로 변환 (예측값)
predict = tf.cast(H > 0.5, dtype=tf.float32)
# 예측값과 정답을 비교해서 True of False를 0. or 1. 로 변환
equal = tf.cast(tf.equal(predict, Y), dtype=tf.float32)
accuracy = tf.reduce_mean(equal)

# 정확도 측정
# -> 우리는 데이터가 부족해서 학습데이터(x_data, y_data) 를 줬지만, 실제로는 검증데이터가 필요!
print(sess.run(accuracy, feed_dict={X: x_data, Y: y_data}))

# 8. prediction
print(sess.run(H, feed_dict={X: [[4, 2]]}))
