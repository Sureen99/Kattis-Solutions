x=list(map(int,input().split()))
for i in range(1, x[2]+1):
    if i%x[0]==0 and i%x[1]==0:
        print("FizzBuzz")
    elif i%x[0]==0:
        print("Fizz")
    elif i%x[1]==0:
        print("Buzz")
    else:
        print(i)
