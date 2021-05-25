#pip install pytube3

from pytube import YouTube
from glob import glob
from os import path, mkdir, rename

target_url = input('download url : ')
download_path = 'c:/test_mp3'

if not path.exists(download_path):
    mkdir(download_path)
    print('mkdir : ' + download_path)
else:
    print('exists : ' + download_path)

target = YouTube(target_url)
try:
    target.streams.filter(only_audio=True).first().download(download_path)
except:
    print('download error')

rename(glob(download_path+'/*.mp4')[0], download_path+'/'+target.title.replace('/','_')+'.mp3')
print('mp4 to mp3 complete')

# pip install git+https://github.com/ssuwani/pytube