x=input()
y=''
for i in range(len(x)-1):
    if x[i]==x[i+1]:
        continue
    else:
        y+=x[i]
y+=x[-1]
print(y)
