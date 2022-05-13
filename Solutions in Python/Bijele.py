x=list(map(int,input().split()))
x[0]=1-x[0]
x[1]=1-x[1]
x[2]=2-x[2]
x[3]=2-x[3]
x[4]=2-x[4]
x[5]=8-x[5]
y=''
for i in x:
    y+=str(i)+' '
print(y)
