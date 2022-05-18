input = input()
index = 0
for i in range(len(input)):
    if input[i]=="a":
        index = i
        break
    else:
        continue
    
print(input[index:])
