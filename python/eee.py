m=int(input())
while(m):
    n,x=map(int,input().split())
    a=list(map(int,input().strip().split()))[:n]
    a.sort()
    l=[]
    for i in range(n):
        if a[i] not in l:
            l.append(a[i])
    t=len(l)
    ans=0
    if(x<t and n!=t):
        ans=t
    elif(t==1):
        ans=t
    elif:
        v=x-(n-t)
        ans=t-v
    print(ans)
    m-=1






