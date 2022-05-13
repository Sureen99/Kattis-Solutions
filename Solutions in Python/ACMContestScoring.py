x=[]
while True:
    y=input().split()
    if y==['-1']:
        break
    else:
        x.append(y)
a=0
b=0
c=[]
d=[]
for i in x:
    c.append(i[1])
    if 'right' in i:
        a+=1
        b+=int(i[0])
        d.append(i[1])
for j in d:
    b+=(c.count(j)-1)*20
print(str(a)+' '+str(b))
