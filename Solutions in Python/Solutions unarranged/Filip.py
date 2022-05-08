import sys
for i in sys.stdin:
    A,B=i.split()
a=A[::-1]
b=B[::-1]
if int(a)<int(b):
    print(b)
else:
    print(a)
