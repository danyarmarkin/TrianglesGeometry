from math import *
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
AB = 0
BC = 0
AC = 0
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
        AB = l
    #BC
    if a == 4:
        l = getLen(s)
        T[ind].append(l)
        TN[ind] *= l<200
        BC = l
    #AC
    if a == 5:
        l = getLen(s)
        T[ind].append(l)
        TN[ind] *= l<200
        AC = l
    i+=1
    
T1 = []
TM = dict()
for j in range(len(T)):
    p = T[j]
    p1 = T[j]
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
    for k in range(6):
        u = p[k]
        if u >= 100 or u <= -100:
            p[k]-=u-99
            p[(k+2)%6]-=u-99
            p[(k+4)%6]-=u-99
    ab = sqrt((p[0]-p[2])**2+(p[1]-p[3])**2)
    bc = sqrt((p[2]-p[4])**2+(p[3]-p[5])**2)
    ac = sqrt((p[0]-p[4])**2+(p[1]-p[5])**2)
    if ab%1==0 and bc%1==0 and ac%1==0:     
        TM[str(len(T1))] = abs(p[0])+abs(p[1])+abs(p[2])+abs(p[3])+abs(p[4])+abs(p[5])
        T1.append(p)
    


TO = []
for v in T1:
    p = []
    for u in T1[T1.index(v)]:
        p.append("["+str(u)+"]")
    TO.append(p)

TD = list(TM.items())
TD.sort(key=lambda j: j[1])
out = open("output.txt", "w")
for j in TD:
    del TO[int(j[0])][6:]
    out.write("list_of_vars = "+str(TO[int(j[0])]).replace("'", "") + "\n")
f.close()
out.close()
print("done")

    


