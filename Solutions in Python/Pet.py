a=[]
for i in range(5):
    b=input().split()
    b=[int(j) for j in b]
    a.append(sum(b))
print(str(a.index(max(a))+1)+' '+str(max(a)))
