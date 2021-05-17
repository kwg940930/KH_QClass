# -*- coding:utf-8 -*-

from bs4 import BeautifulSoup
from selenium import webdriver


url = 'https://www.instagram.com/explore/tags/' + input('search tags : ')

driver = webdriver.Chrome('c:/drivers/chromedriver.exe')

driver.implicitly_wait(3)
driver.get(url)

soup = BeautifulSoup(driver.page_source, 'html.parser')

print(soup.find('div', {'class', 'KL4Bh'}))

driver.quit()