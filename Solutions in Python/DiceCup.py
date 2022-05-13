x=input().split()
y=[]
for i in range(1,int(x[0])+1):
    for j in range(1,int(x[1])+1):
        y.append(i+j)
z=[]
for k in y:
    z.append(y.count(k))
a=set()
for l in y:
    if y.count(l)==max(z):
        a.add(l)
for i in a:
    print(i)
