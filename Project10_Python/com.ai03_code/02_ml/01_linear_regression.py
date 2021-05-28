import tensorflow as tf

# 1. traning data_tmp set (학습 데이터 셋)
x = [1, 2, 3, 4, 5]
# label (정답)
y = [1, 2, 3, 4, 5]

# 2. Weight & bias 정의 : 학습이 반복되면서 내부적으로 변함
# W : tf.Variable -> 변수 node
#     tf.random_normal -> 초기값은 표준 정규분포 랜덤값으로
#     [1] -> 한개만 구한다
#     name='weight' -> 그래프 내부적으로 사용하는 이름
W = tf.Variable(tf.random_normal([1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')

# 3. Hypothesis (가설) : 만들어야 하는 최종 model
H = W * x + b

# 4. loss (cost) function : 손실함수 (비용함수)
# 가설에서 정답을 빼서 제곱한 값들을 모두 더해서 평균을 낸 그래프
# tf.square : 제곱 / tf.reduce_mean : 평균
loss = tf.reduce_mean(tf.square(H - y))

# 5. loss 함수의 값을 최소화하는 W와 b를 구하는 작업. 경사하강법 (gradient descent algorithm)
# optimizer : loss함수를 미분해서 기울기를 확인, 이동시켜주는 역할
# learning_rate : 이동하는 상수값
optimizer = tf.train.GradientDescentOptimizer(0.01)
# loss값을 최소화시키는 작업 (0까지 줄여나가는 것)
# minimize 는 1번 실행
# 여기까지가 그래프 구현
train = optimizer.minimize(loss)

# 6. session 생성
sess = tf.Session()
# 초기화 : tf.Variable() 을 사용하면, 반드시 초기화 작업 필요!
sess.run(tf.global_variables_initializer())

# 7. 반복학습
epochs = 3000
for step in range(epochs):
    tmp, loss_val, W_val, b_val = sess.run([train, loss, W, b])
    if step % 300 == 0:
        # W는 1에,b와 loss는 0에 가까워지는 걸 볼 수 있다
        # H = (1.0000076) * x + (-2.7278596e-05)
        print('W:{} \t b:{} \t loss:{} '.format(W_val, b_val, loss_val))
