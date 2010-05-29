import sys,threading,os
from time import sleep

problem = sys.argv[1]

class MyThread (threading.Thread):

    def run(self):
        print os.popen('python problem' + problem.strip() + ".py").readlines()        

threader = MyThread()
threader.start()
sleep(60)
sys.exit(1)

