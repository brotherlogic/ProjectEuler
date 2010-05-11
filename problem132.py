
period_stash = {}

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
    return k % period(p) == 0

def isPrime(n):
    # range starts with 2 and only needs to go up the squareroot of n
    for x in range(2, int(n**0.5)+1):
        if n % x == 0:
            return False
    return True

def compute(K):
    vals = []
    for i in range(7,1000000,2):
        if i % 5 != 0 and isPrime(i) and does_div(K,i):
            vals.append(i)
            print len(vals),i
            if len(vals) == 40:
                return vals

a = compute(pow(10,9))
print a
print sum(a)
#print period(3)

