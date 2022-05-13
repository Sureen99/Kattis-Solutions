def HCF(a,b):
    if a%b==0:
        return b
    elif b%a==0:
        return a
    elif a>b:
        c=1
        for i in range(1,b):
            if a%i==0 and b%i==0:
                c=i
    else:
        c=1
        for i in range(1,a):
            if a%i==0 and b%i==0:
                c=i
    return c
x=input()
y=list(map(int,input().split()))
for i in y[1:]:
    print(str(int(y[0]/HCF(y[0],i)))+'/'+str(int(i/HCF(y[0],i))))
