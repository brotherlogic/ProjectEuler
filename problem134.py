import sys
from math import log10,floor

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
    start = 1
    number = start*100+p1
    while not number % p2 == 0:
        start += 1
        number = start*100+p1
    return number

def rmatch(p1,p2):
    v = int(floor(log10(p1)))+1
    print p1,v
    start = 2
    number = p2*start
    while number % 10**v != p1:
        start += 1
        number = p2*start
    return number

#print match(19,23)
#sys.exit(1)

v = 0
for i in range(0,len(p)-1):
    s = match(p[i],p[i+1])
    print i,len(p)
    v += s
