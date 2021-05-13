# -*- coding:utf-8 -*-
# pip install flask_cors
from flask import Flask, render_template
from bs4 import BeautifulSoup
import requests
import json
import flask_cors


app = Flask(__name__)
flask_cors.CORS(app)


@app.route('/')
def root():
    return render_template('index.html')


@app.route('/crawling')
def naverMovieCrawling():
    # naver 영화에서 영화제목과 별점을 가지고 와서
    # {'movies':[{'title':제목, 'star': 별점}, ...]} 형태의 json 객체로 리턴하자
    resp = requests.get('https://movie.naver.com/movie/running/current.nhn#')
    soup = BeautifulSoup(resp.text, 'html.parser')
    
    movies = soup.find_all('dl', class_='lst_dsc')
    print(movies)
    
    result_list = list()
    for movie in movies:
        res = dict()
        res['title'] = movie.find('a').text
        res['star'] = movie.select('.num')[0].text
        
        result_list.append(res)
        
    res_dict = {'movies' : result_list}
    
    result_json = json.dumps(res_dict, ensure_ascii=False)
    print(result_json)
    
    return result_json
    
    


if __name__ == '__main__':
    app.run(host='localhost', port='8282')