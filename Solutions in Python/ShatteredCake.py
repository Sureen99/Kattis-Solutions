x=int(input())
y=0
for i in range(int(input())):
    z=input().split()
    y+=int(z[0])*int(z[1])
print(y//x)
