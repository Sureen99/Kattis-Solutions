y=0
z=[]
a=0
for i in range(5):
    x=input()
    y+=x.count("k")
    z.extend(x)
for i in range(len(z)):
    if i<=14:
        if z[i]=='k':
            if i%5==0:
                if z[i+7]=="k" or z[i+11]=="k":
                    a=1
            elif i%5==1:
                if z[i+7]=="k" or z[i+11]=="k" or z[i+9]=="k":
                    a=1
            elif i%5==2:
                if z[i+7]=='k' or z[i+11]=='k' or z[i+9]=='k' or z[i+3]=="k":
                    a=1
            elif i%5==3:
                if z[i+11]=='k' or z[i+9]=='k'or z[i+3]=='k':
                    a=1
            elif i%5==4:
                if z[i+9]=='k' or z[i+3]=='k':
                    a=1
    elif i <=19:
        if z[i]=='k':
            if i%5==0 or i%5==1:
                if z[i+7]=='k':
                    a=1
            elif i%5==2:
                if z[i+7]=='k' or z[i+3]=='k':
                    a=1
            else:
                if z[i+3]=='k':
                    a=1
if a==1 or y!=9:
    print('invalid')
else:
    print('valid')
