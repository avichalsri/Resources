n=int(input())
a=list(input().split())
a=sorted(a,reverse=True)
for i in range(n-1):
    x=a[i]+a[i+1]
    y=a[i+1]+a[i]
    if (int(x)>int(y)):
        a[i+1]=x
    else:
        a[i+1]=y
print(a[n-1])
    
    
