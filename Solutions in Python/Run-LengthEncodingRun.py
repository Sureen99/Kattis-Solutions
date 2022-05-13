x=input().split()
if x[0]=='E':
    y=''
    z=0
    for i in range(len(x[1])-1):
        if x[1][i]==x[1][i+1]:
            z+=1
            continue
        else:
            z+=1
            y+=(x[1][i]+str(z))
            z=0
    y+=(x[1][-1]+str(z+1))
    print(y)
else:
    y=''
    for i in range(0,len(x[1]),2):
        y+=(x[1][i]*int(x[1][i+1]))
    print(y)
