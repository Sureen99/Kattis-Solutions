x=input()
y=0
for i in range(int(x)):
    z=input()
    y+=int(z[:-1])**int(z[-1])
print(y)
