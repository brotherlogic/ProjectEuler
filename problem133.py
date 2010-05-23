import sys

period_stash = {}

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a
 
def lcm(a, b):
    return (a*b) / gcd(a, b)
 
def isPrime(p):
    return (p > 1) and all(f == p for f,e in factored(p))
 
primeList = [2,3,5,7]
def primes():
    for p in primeList:
        yield p
    while 1:
        p += 2
        while not isPrime(p):
            p += 2
        primeList.append(p)
        yield p
 
def factored( a):
    for p in primes():
        j = 0
        while a%p == 0:
            a /= p
            j += 1
        if j > 0:
            yield (p,j)
        if a < p*p: break
    if a > 1:
        yield (a,1)
 
 
def multOrdr1(a,(p,e) ):
    m = p**e
    t = (p-1)*(p**(e-1)) #  = Phi(p**e) where p prime
    qs = [1,]
    for f in factored(t):
        qs = [ q * f[0]**j for j in range(1+f[1]) for q in qs ]
    qs.sort()
 
    for q in qs:
        if pow( a, q, m )==1: break
    return q
 
 
def multOrder(a,m):
    mofs = (multOrdr1(a,r) for r in factored(m))
    return reduce(lcm, mofs, 1)

def period(p):
    if p in period_stash:
        return period_stash[p]
    
    i = 10
    c = 1
    while i % p != 1:
        c += 1
        i *= 10 % p

    period_stash[p] = c
    return c


def does_div(k,p):
    return k % multOrder(10,p) == 0

def isPrime(n):
    # range starts with 2 and only needs to go up the squareroot of n
    for x in range(2, int(n**0.5)+1):
        if n % x == 0:
            return False
    return True

def compute(K):
    vals = []
    for i in range(7,1000000,2):
#        if isPrime(i):
#            print i,period(i),len(vals)
        if i % 5 != 0 and isPrime(i) and does_div(K,i):            
            vals.append(i)
            print i
            if len(vals) == 40:
                return vals

#print isPrime(14087),period(14087)
val = 10000

#a = compute(val)
a = []
for i in range(7,100001):
    if isPrime(i):
        found = False
        for j in range(1,500):
            if does_div(10**j,i):
                found = True
                break
        if not found:
            a.append(i)

print sum(a)


