x = int(input())
for j in range(x):
    y = input().split()
    for k in range(len(y)):
        y[k]=int(y[k])
    sum = 0
    for i in range(y[0]+1):
        if i==0:
            sum-=y[i]
        else:
            sum+=y[i]

    print(sum+1)
