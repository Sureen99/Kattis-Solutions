x=float(input())
y=0
for i in range(int(input())):
    z=list(map(float,input().split()))
    y+=z[0]*z[1]
print(round(y*x,7))
