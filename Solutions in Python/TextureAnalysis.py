a=0
while True:
    x=input()
    a+=1
    if x=='END':
        break
    else:
        y=[]
        z=[]
        for i in range(len(x)):
            if x[i]=='*':
                y.append(i)
        for j in range(len(y)-1):
            z.append(y[j+1]-y[j])
        if len(set(z))==1 or len(set(z))==0:
            print(str(a)+' EVEN')
        else:
            print(str(a)+ ' NOT EVEN')
