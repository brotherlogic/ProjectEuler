import sys,time
from math import log10,floor,ceil

primes = [0]*1000001

for i in range(2,len(primes)):
    if primes[i] == 0:
        for i in range(2*i,len(primes),i):
            primes[i] = 1

p = []
for i in range(5,len(primes)):
    if primes[i] == 0:
        p.append(i)

def match(p1,p2):
    mult = 10**ceil(log10(p1))
    start = 1
    number = start*mult+p1
    while not number % p2 == 0:
        start += 1
        number = start*mult+p1
    return number,start

def rmatch(p1,p2):
    v = int(floor(log10(p1)))+1
    print p1,v
    start = 2
    number = p2*start
    while number % 10**v != p1:
        start += 1
        number = p2*start
    return number

a = time.time()
s = match(998717,998737)
print s
print time.time()-a
#sys.exit(1)

v = 0
best_match = (0,0)
best_time = 0
for i in range(len(p)-2,0,-1):
    a = time.time()
    s = match(p[i],p[i+1])
    b = time.time()-a
    print i,len(p),p[i],p[i+1],s,b
    if b > best_time:
        best_time = b
        best_match = (p[i],p[i+1])
    #print best_time,best_match
    v += s[0]
