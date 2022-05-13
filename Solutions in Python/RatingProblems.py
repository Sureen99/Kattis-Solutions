x=input().split()
y=0
for i in range(int(x[1])):
    y+=int(input())
print(str((y-3*(int(x[0])-int(x[1])))/int(x[0]))+ ' ' +str((y+3*(int(x[0])-int(x[1])))/int(x[0])))
