import tensorflow as tf
import numpy as np
import pandas as pd

# data loading
data = pd.read_csv('../data/ozone.csv', sep=',')

# 결측값 제거
data = data.dropna(how='any')

# print(data.head())

df = data[['Solar.R', 'Wind', 'Temp', 'Ozone']]

# Standardization, Normalization
df['Solar.R_stan'] = (df['Solar.R'] - df['Solar.R'].mean()) / df['Solar.R'].std()
df['Wind_stan'] = (df['Wind'] - df['Wind'].mean()) / df['Wind'].std()
df['Temp_stan'] = (df['Temp'] - df['Temp'].mean()) / df['Temp'].std()
df['Ozone_stan'] = (df['Ozone'] - df['Ozone'].mean()) / df['Ozone'].std()
# print(df.head())

# training data set
x_data = df[['Solar.R_stan', 'Wind_stan', 'Temp_stan']].values
y_data = df['Ozone_stan'].values.reshape(-1, 1)

# placeholder
X = tf.placeholder(shape=[None, 3], dtype=tf.float32)
Y = tf.placeholder(shape=[None, 1], dtype=tf.float32)

# Weight & bias
W = tf.Variable(tf.random_normal([3, 1]), name='weight')
b = tf.Variable(tf.random_normal([1]), name='bias')

# Hypothesis
H = tf.matmul(X, W) + b

# cost function
cost = tf.reduce_mean(tf.square(H - Y))

# train
train = tf.train.GradientDescentOptimizer(learning_rate=0.1).minimize(cost)

# session
sess = tf.Session()
sess.run(tf.global_variables_initializer())

# 학습
for step in range(3000):
    _, cost_val = sess.run([train, cost], feed_dict={X: x_data, Y: y_data})
    if step % 300 == 0:
        print('cost: {}'.format(cost_val))

# prediction
# Solar.R, Wind, Temp
input_data = [[190.0, 7.4, 67.0]]
print(sess.run(H, feed_dict={X: input_data}))
