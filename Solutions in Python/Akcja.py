x=int(input())
z=[]
for i in range(x):
    z.append(int(input()))
z.sort(reverse=True)
a=0
for i in range(len(z)):
    if i%3==2:
        continue
    else:
        a+=z[i]
print(a)
