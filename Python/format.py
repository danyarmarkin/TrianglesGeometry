def getPos(s):
    x = 0
    y = 0
    m = 0
    for i in s:
        if m==0 and 48<=ord(i)<=57:
            x=x*10+int(i)
        if i==";":
            m=1
        if m==1 and 48<=ord(i)<=57:
            y=y*10+int(i)
    return x, y

def getLen(s):
    l = 0
    for i in s:
        if 48<=ord(i)<=57:
            l = l*10+int(i)
    return int(l/10)
    
f = open("triangles.txt")
n = int(input())
i = 0
T = []
TN = []
for line in f:
    s = str(line).replace("\n", "")
    a = i % 7
    ind = i // 7
    #Ax Ay
    if a == 0:
        p = []
        x, y = getPos(s)
        p.append(x)
        p.append(y)
        T.append(p)
        TN.append(x < 200 and y < 200)
    #Bx By
    if a == 1:
        x, y = getPos(s)
        T[ind].append(x)
        T[ind].append(y)
        TN[ind] *= x < 200 and y < 200
    #Cx Cy
    if a == 2:
        x, y = getPos(s)
        T[ind].append(x)
        T[ind].append(y)
        TN[ind] *= x < 200 and y < 200
    #AB
    if a == 3:
        l = getLen(s)
        T[ind].append(l)
        TN[ind] *= l<200
    #BC
    if a == 4:
        l = getLen(s)
        T[ind].append(l)
        TN[ind] *= l<200
    #CD
    if a == 5:
        l = getLen(s)
        T[ind].append(l)
        TN[ind] *= l<200
    i+=1
    
T1 = []
TM = dict()
for j in range(len(T)):
    p = T[j]
    b = TN[j]
    if b == False:
        continue
    Zx = int((p[0]+p[2]+p[4])/3)
    Zy = int((p[1]+p[3]+p[5])/3)
    for k in range(len(p)):
        if k%2==0:
            p[k]-=Zx
        else:
            p[k]-=Zy
    for k in range(len(p)):
        u = p[k]
        if u >= 100 or u <= -100:
            p[k]-=u-99
            p[(k+2)%6]-=u-99
            p[(k+4)%6]-=u-99
    T1.append(p)


for j in T1:
    TM[str(T1.index(j))] = abs((sum(j)/len(j)))

TD = list(TM.items())
TD.sort(key=lambda j: j[1])
out = open("output.txt", "w")
for j in TD:
    del T1[int(j[0])][6:]
    out.write(str(T1[int(j[0])]) + "\n")
f.close()
out.close()
print("done")

    


