x=input()
y=[1,0,0]
for i in x:
    if i=="A":
        y[0],y[1]=y[1],y[0]
    elif i=="B":
        y[1],y[2]=y[2],y[1]
    elif i=="C":
        y[0],y[2]=y[2],y[0]
print(y.index(1)+1)
