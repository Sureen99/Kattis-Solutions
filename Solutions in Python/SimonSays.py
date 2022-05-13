x=input()
for i in range(int(x)):
    y=input()
    if y[:10]=="Simon says":
        print(y[11:])
