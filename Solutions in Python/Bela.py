x=input().split()
DD={"A":11,"K":4,"Q":3,"J":20,"T":10,"9":14,"8":0,"7":0}
ND={"A":11,"K":4,"Q":3,"J":2,"T":10,"9":0,"8":0,"7":0}
y=0
for i in range(4*int(x[0])):
    z=input()
    if z[1]==x[1]:
        y+=DD[z[0]]
    else:
        y+=ND[z[0]]
print(y)
