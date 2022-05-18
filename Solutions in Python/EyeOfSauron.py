input = input()
if len(input)%2==1:
    print("fix")
else:
    if input[(len(input)//2)-1]=="(" and input[(len(input)//2)]==")":
        print("correct")
    else:
        print("fix")
