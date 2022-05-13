a=0
while True:
    x=int(input())
    a+=1
    if x==0:
        break
    else:
        y=[]
        for i in range(x):
            y.append(input())
        print("SET "+str(a))
        if x%2==0:
            for i in range(0,len(y),2):
                print(y[i])
            for j in range(len(y)-1,0,-2):
                print(y[j])
        else:
            for i in range(0,len(y),2):
                print(y[i])
            for j in range(len(y)-2,0,-2):
                print(y[j])
