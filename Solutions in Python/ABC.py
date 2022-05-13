x=list(map(int,input().split()))
y=input()
k=[0,0,0]
k[y.index('B')]=x[3-x.index(max(x))-x.index(min(x))]
k[y.index('C')]=max(x)
k[y.index('A')]=min(x)
z=''
for i in k:
    z+=str(i)+' '
print(z)
