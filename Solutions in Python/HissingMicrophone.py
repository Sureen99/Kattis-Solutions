input = input()
flag = True
for i in range(len(input)):
    if i!=len(input)-1:
        if input[i]=="s" and input[i+1]=="s":
            flag = False

if flag:
    print("no hiss")
    
else:
    print("hiss")
