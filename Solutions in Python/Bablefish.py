import sys
x=sys.stdin.readlines()
z=dict()
for i in x:
    if ' ' in i:
        y=i.rstrip('\n').split()
        z[y[1]]=y[0]
    elif i.rstrip('\n')=='':
        continue
    else:
        if i.strip('\n') in z:
            print(z[i.strip('\n')])
        else:
            print('eh')
