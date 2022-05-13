x=input()
while len(x)!=1:
    y=1
    for i in x:
        if i!='0':
            y*=int(i)
    x=str(y)
print(x)
