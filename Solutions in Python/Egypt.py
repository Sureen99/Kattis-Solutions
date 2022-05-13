while True:
    x=list(map(int,input().split()))
    if x==[0,0,0]:
        break
    else:
        b=[i for i in x if i!=max(x) and i!=min(x)]
        if b==[]:
            b.append(min(x))
        if max(x)**2==min(x)**2 + max(b)**2:
            print("right")
        else:
            print("wrong")
