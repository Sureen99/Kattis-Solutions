x=list(map(int,input().split()))
for i in range(x[0]):
    y=int(input())
    if y<=((x[1])**2 + (x[2])**2)**(1/2):
        print("DA")
    else:
        print("NE")
