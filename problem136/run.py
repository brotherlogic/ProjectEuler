import sys
from math import sqrt,floor,ceil

def computeBounds(x):
    return [floor(max(computeBounds2(x))),ceil(max(computeBounds1(x)))]

def computeBounds1(x):
    [a,b] = computeRoots(3,2*x,-x*x-50000000)
    if a < 0:
        return [0,b]
    else:
        return [a,b]

def computeBounds2(x):
    [a,b] = computeRoots(3,2*x,-x*x)
    if a < 0:
        return [0,b]
    else:
        return [a,b]


def computeRoots(a,b,c):
    if (b*b - 4*a*c) < 0:
        return [0,0]
    val = sqrt(b*b - 4 * a *c)
    a = (-b + val)/(2*a)
    b = (-b - val)/(2*a)
    if a > b:
        return [b,a]
    else:
        return [a,b]


vals = [0]*50000000
for x in range(1,10000000):
    found = False
    [bot,top] = computeBounds(x)
    for a in range(bot,top):
        val = 3*a*a + 2*a*x - x*x
        if val > 0 and val < 50000000:
            found = True
            vals[val] += 1

count = 0
for val in vals:
    if val == 1:
        count += 1
print count
