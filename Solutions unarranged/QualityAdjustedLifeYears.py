QALY=0.0
for i in range(int(input())):
    x=input().split()
    QALY+=float(x[0])*float(x[1])
print(QALY)
