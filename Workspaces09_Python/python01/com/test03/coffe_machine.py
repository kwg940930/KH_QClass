def coffee(quantity, price):
    change = price - (quantity * 100)
    if change < 0:
        prn()
    else:
        prn(quantity, change)



def prn(quantity=0, change=0):
    if quantity == 0 & change == 0:
        print('금액이 모자랍니다...')
    else:
        print('커피 {} 잔이 나왔습니다.\n잔돈은 {} 원 입니다.'.format(quantity, change))

    
    
def start():
    q = int(input('커피 몇 잔이 필요하신가요?'))
    p = int(input('돈을 넣어주세요(1잔에 100원)'))
    coffee(q, p)



if __name__ == '__main__':
    start()