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
for i in range(5, 0, -1):
    print('*' * (i))
print('-----')




'''
    *
   **
  ***
 ****
*****
'''
for i in range(5, 0, -1):
    print()
    for j in range(i-1):
        print(' ',end='')
    print('*'*(6-i),end='')
print()
print('-----')



'''
*****
 ****
  ***
   **
    *
'''
for i in range(0, 5):
    print(' '*i,end='')
    for j in range(5, i, -1):
        print('*',end='')
    print()
print()
print('-----')
    
    

'''
    *
   ***
  *****
 *******
*********
'''
for i in range(5, 0, -1):
    print()
    for j in range(i-1):
        print(' ',end='')
    print('*'*(((6-i)*2)-1),end='')