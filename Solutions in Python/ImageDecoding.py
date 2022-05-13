count=0
while True:
    x=int(input())
    if x==0:
        break
    else:
        if count!=0:
            print('')
        a=[]
        for i in range(x):
            b=''
            y=input().split()
            for j in range(len(y[1:])):
                if j%2==0 and y[0]=='#':
                    b+='#'*int(y[j+1])
                elif j%2==0 and y[0]=='.':
                    b+='.'*int(y[j+1])
                elif j%2==1 and y[0]=='#':
                    b+='.'*int(y[j+1])
                elif j%2==1 and y[0]=='.':
                    b+='#'*int(y[j+1])
            a.append(b)
        c=[]
        for i in a:
            print(i)
            c.append(len(i))
        if len(set(c))!=1:
            print("Error decoding image")
        count+=1
