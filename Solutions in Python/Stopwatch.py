y=0
z=int(input())
if z==0:
    print(0)
elif z==1:
    print("still running")
else:
    for i in range(z):
        if i%2==0:
            x=int(input())
        else:
            y+=int(input())-x
            x=0
    if x==0:
        print(y)
    else:
        print("still running")
