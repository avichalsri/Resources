c=[7,20,37,59,71,88,104,121,136,152,168,184,202,213,229,250]
sam =[23,45,232,142,55,13,121,235,231,23,29,99,101,65,32,109,143,174,91,199,212,66,48,111,222,153,185,255]
ans=[]*16
ct=[0]*16
su=[0]*16
m=[0]*16
print("Enter n:")
n=int(input())
inp=[]
print("Enter the data:")
for i in range(n):
    p=list(map(int,input().split()))
    inp.append(p)
flag=1
while(1):
    for i in range(len(sam)):
        mi=1000
        point=0
        for j in range(16):
            if abs(sam[i]-c[j])<mi:
                mi=sam[i]-c[j]
                point=j
        ans.append((sam[i],point))
        ct[point]+=1
        su[point]+=sam[i]
    for i in range(16):
        m[i]=su[i]/ct[i]
    print("\n\nAfter "+str(flag)+" Iteration, the centroids are:")
    flag+=1
    for ch in m:
        print(round(ch,2),end=" ")
    if(m==c):
        break
    else:
        c=m
print("\n\nThe final centroids are:")
for ch in c:
    print(round(ch,2),end=" ")
print()
print("\nThe resultant is :")
for i in range(n):
    for j in range(n):
        mi=1000
        for k in range(16):
            if abs(inp[i][j]-c[k])<mi:
                mi=inp[i][j]-c[k]
                an=k
        print(an,end=" ")
    print()






        
    
