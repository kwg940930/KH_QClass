'''
*
**
***
****
*****
'''
for i in range(5):
    for j in range(i + 1):
        print('*', end='')
    print()
print('-----')

for i in range(5):
    print('*' * (i+1))
print('-----')



'''
*****
****
***
**
*
'''
for i in range(5):
    print('*' * (5 - i))
print('-----')




'''
    *
   **
  ***
 ****
*****
'''
for i in range(5):
    print(' '*(4-i) + '*' * (1 + i))
print('-----')



'''
*****
 ****
  ***
   **
    *
'''
for i in range(5):
    print(' '*(i) + '*'*(5-i))
print('-----')
    
    

'''
    *
   ***
  *****
 *******
*********
'''
for i in range(5):
    print(' ' * (4 - i) + '*' * (2 * i + 1))