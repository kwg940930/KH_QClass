# -*- coding:utf-8 -*-
import requests     # -> url, lib라는 내장 모듈보다 사용이 쉬움
import json

# https://www.starbucks.co.kr

def getSiDo():
    url = 'https://www.starbucks.co.kr/store/getSidoList.do'
    resp = requests.post(url)
    # print(resp)
    # print(resp.json()['list'][0])
    sido_json = resp.json()['list']
    sido_code = list(map(lambda x: x['sido_cd'], sido_json))
    # print(sido_code)
    sido_name = list(map(lambda x: x['sido_nm'], sido_json))
    # print(sido_name)
    sido_dict = dict(zip(sido_code, sido_name))
    # print(sido_dict)
    return sido_dict
    
    
def getGuGun(sido_code):
    url = 'https://www.starbucks.co.kr/store/getGugunList.do'
    resp = requests.post(url, data={'sido_cd':sido_code})
    # print(resp.json())
    gugun_json = resp.json()['list']
    gugun_dict = dict(zip(list(map(lambda x: x['gugun_cd'], gugun_json)), list(map(lambda x: x['gugun_nm'], gugun_json))))
    # print(gugun_dict)
    return gugun_dict

def getStore(sido_code='', gugun_code=''):
    url = 'https://www.starbucks.co.kr/store/getStore.do'
    resp = requests.post(url, data={
                                    'ins_lat': '37.5009759',
                                    'ins_lng': '127.03735019999999',
                                    'p_sido_cd': sido_code,
                                    'p_gugun_cd': gugun_code,
                                    'in_biz_cd': '',
                                    'set_date': ''})
    # print(resp.json()['list'][0])
    store_json = resp.json()['list']
    
    store_list = list()
    count = 0
    
    for store in store_json:
        store_dict = dict()
        store_dict['s_name'] = store['s_name']
        store_dict['tel'] = store['tel']
        store_dict['doro_address'] = store['doro_address']
        store_dict['lat'] = store['lat']
        store_dict['lot'] = store['lot']
        store_list.append(store_dict)
        count += 1
        
    store_tmp = dict()
    store_tmp['store_list'] = store_list
    store_tmp['count'] = count
    result_json = json.dumps(store_tmp, ensure_ascii=False)
    # print(result_json)
    return result_json

if __name__ == '__main__':
    print(getSiDo())
    sido = input('시도 코드를 입력해 주세요 : ')
    if sido == '17':
        print(getStore(sido_code=17))
    else:
        print(getGuGun(sido))
        gugun = input('구군 코드를 입력해 주세요 : ')
        print(getStore(gugun_code=gugun))