x=input().split()
if int(x[0])-int(x[1])>int(x[1]):
    y=int(x[0])-int(x[1])
else:
    y=int(x[1])
if int(x[0])-int(x[2])>int(x[2]):
    z=int(x[0])-int(x[2])
else:
    z=int(x[2])
print(y*z*4)
