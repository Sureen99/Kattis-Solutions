x=input()
y=list(map(int,input().split()))
z=0
for i in y:
    if i<0:
        z+=1
print(z)
