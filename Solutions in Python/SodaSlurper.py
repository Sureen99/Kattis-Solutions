x=list(map(int,input().split()))
y=0
z=x[0]+x[1]
while z>=x[2]:
    y+=z//x[2]
    z=z//x[2] + z%x[2]
print(y)
