# -*- coding:utf-8 -*-

from bs4 import BeautifulSoup
import requests
import json

resp = requests.get('https://comic.naver.com/webtoon/weekdayList.nhn?week=')
# print(resp.text)
soup = BeautifulSoup(resp.text, 'html.parser')

webtoons = soup.find('ul', {'class': 'img_list'})
# print(webtoons)

dl = webtoons.select('dl')
# print(dl[0])

lst = list()

for chd in dl:
    title = chd.find('a')['title']
    star = chd.find('strong').text
    # print('{}[{}]'.format(title, star))
    
    tmp = {}
    tmp['title'] = title
    tmp['star'] = star
    lst.append(tmp)
    
# print(lst)


res = {}
res['webtoons'] = lst
# print(res)

res_json = json.dumps(res, ensure_ascii=False)
# print(res_json)

with open('webtoons.json', 'w', encoding='utf-8') as f:
    f.write(res_json)