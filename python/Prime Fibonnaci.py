import math

n1,n2=map(int,input().split())

l=[i for i in range(n2+1)]

l[1]=0

for i in range(2,n2+1):
    if(l[i] == i ):
        for j in range(2*i,n2+1,i):
            l[j]=0

k=[]

for i in l:
    if(i!=0 and i>=n1):
        k.append(i)

#print(k)

s=set()

for i in range(len(k)-1):
    for j in range(i+1,len(k)):
        s.add(int(str(k[i])+str(k[j])))
        s.add(int(str(k[j])+str(k[i])))

k=list(s)

k.sort()

#print(k)

minn=k[0]

maxx=k[-1]

m=[i for i in range(maxx+1)]

m[1]=0

for i in range(2,maxx+1):
    if(m[i] == i):
        for j in range(2*i,maxx+1,i):
            m[j]=0

prim2list=[]

for i in m:
    if(i >= minn and i in s):
        prim2list.append(i)

#print(prim2list)

minn=prim2list[0]

maxx=prim2list[-1]

lenn=len(prim2list)

#print(minn,maxx,lenn)

cnt=2

while(cnt<lenn):
    tmp=minn
    minn=maxx
    maxx=tmp+maxx
    cnt+=1

print(maxx)

