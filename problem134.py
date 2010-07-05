from math import log10,pow
import sys

primes = [0]*101

for i in range(2,len(primes)):
    if primes[i] == 0:
        for j in range(i*2,len(primes),i):
            primes[j] = 1

def find(p1,p2):    
    mult = pow(10,1+int(log10(p1)))
    i = int(mult)
    while (i*mult+p1) % p2 != 0:
        i += 1
    return p1,i

primepair = [7,11]
print find(primepair[0],primepair[1])
for i in range(12,len(primes)):
    if primes[i] == 0:
        primepair[0] = primepair[1]
        primepair[1] = i
        print find(primepair[0],primepair[1])
