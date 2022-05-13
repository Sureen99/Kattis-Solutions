x=list(map(int,input().split()))
y={}
for i in range(x[0]):
    z=input().split()
    y[z[0]]=int(z[1])
for j in range(x[1]):
    b=0
    while True:
        a=input().split()
        if a==["."]:
            break
        else:
            for i in a:
                if i in y:
                    b+=y[i]
    print(b)
