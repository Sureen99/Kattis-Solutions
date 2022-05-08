for i in range(int(input())):
    x=input().split()
    y=60*float(x[0])/float(x[1])
    z=60/float(x[1])
    print(str(y-z)+' '+str(y)+' '+str(y+z))
