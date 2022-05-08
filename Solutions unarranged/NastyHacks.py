y=int(input())
for i in range(y):
    x=list(map(int,input().split()))
    if x[1]-x[2]>x[0]:
        print("advertise")
    elif x[1]-x[2]==x[0]:
        print("does not matter")
    else:
        print("do not advertise")
