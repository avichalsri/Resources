K=int(input())
T=int(input())

a=1
b=2
for i in range(0,T):
    a=(K*b+a*a)%3001
    b=(K*a+b)%3001

print(a)
print(b)


t=int(input())
while(t):
    a,b,c,v=map(float,input().split())
    vf=float(a*b*c*v)
    s=float(100/vf)
    sf=round(s,2)
    if(sf<9.58):
        print("Yes")
    else:
        print("No")
    t-=1
