x = input().split()
if x[0]=="OCT":
    if x[1]=="31":
        print("yup")
    else:
        print("nope")
elif x[0] == "DEC":
    if x[1]=="25":
        print("yup")
    else:
        print("nope")
else:
    print("nope")
