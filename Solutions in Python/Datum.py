x=input().split()
if x[1]=='1':
    y=int(x[0])
elif x[1]=='2':
    y=int(x[0])+31
elif x[1]=='3':
    y=int(x[0])+31+28
elif x[1]=='4':
    y=int(x[0])+31+28+31
elif x[1]=='5':
    y=int(x[0])+31+28+31+30
elif x[1]=='6':
    y=int(x[0])+31+28+31+30+31
elif x[1]=='7':
    y=int(x[0])+31+28+31+30+31+30
elif x[1]=='8':
    y=int(x[0])+31+28+31+30+31+30+31
elif x[1]=='9':
    y=int(x[0])+31+28+31+30+31+30+31+31
elif x[1]=='10':
    y=int(x[0])+31+28+31+30+31+30+31+31+30
elif x[1]=='11':
    y=int(x[0])+31+28+31+30+31+30+31+31+30+31
elif x[1]=='12':
    y=int(x[0])+31+28+31+30+31+30+31+31+30+31+30
if y%7==1:
    print('Thursday')
elif y%7==2:
    print('Friday')
elif y%7==3:
    print('Saturday')
elif y%7==4:
    print('Sunday')
elif y%7==5:
    print('Monday')
elif y%7==6:
    print('Tuesday')
elif y%7==0:
    print('Wednesday')
