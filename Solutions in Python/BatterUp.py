x=int(input())
y=list(map(int,input().split()))
sum=0
for i in y:
    if i!=-1:
        sum+=i
print(sum/(x-y.count(-1)))
