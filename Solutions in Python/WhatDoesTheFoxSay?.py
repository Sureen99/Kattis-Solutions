x=int(input())
for i in range(x):
    y=input().split()
    k=[]
    a=''
    while True:
        z=input()
        if z=="what does the fox say?":
            break
        else:
            k.append((z.split())[-1])
    for i in y:
        if i in k:
            continue
        else:
            a+=i+' '
    print(a)
