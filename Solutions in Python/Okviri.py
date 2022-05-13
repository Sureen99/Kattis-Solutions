a=input()
x=''
y=''
z=''
for i in range(len(a)):
    if i==0:
        x+='..#.'
        y+='.#.#'
        z+=('#.'+a[i]+'.')
    elif i%3==2:
        x+='..*.'
        y+='.*.*'
        z+=('*.'+a[i]+'.')
    elif i%3==0:
        x+='..#.'
        y+='.#.#'
        z+=('*.'+a[i]+'.')
    else:
        x+='..#.'
        y+='.#.#'
        z+=('#.'+a[i]+'.')
if len(a)%3==0:
    x+='.'
    y+='.'
    z+='*'
else:
    x+='.'
    y+='.'
    z+='#'
print(x)
print(y)
print(z)
print(y)
print(x)
