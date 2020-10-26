w0=0.3
w1=0.1
w2=0.1
x0=1
x1=0
x2=0
t=0.5
r=0.1
res=[1,1,1,1]
ct=0
print("Enter the inputs:")
j,k=map(int,input().split())
print("x0 x1 x2   z     w0   w1   w2    c0   c1   c2      s      n     e     d     w0'  w1'  w2'")
while(any(res)):
    if(x1==1 and x2==1):
        z=0
    else:
        z=1

    c0=w0*x0
    c1=w1*x1
    c2=w2*x2
    s=c0+c1+c2
    if(s>t):
        n=1
    else:
        n=0
    e=z-n
    res.append(e)
    res=res[1:]
    d=r*e
    m=w0+d*x0
    n=w1+d*x1
    o=w2+d*x2
    if(m==w0 and n==w1 and o==w2):
        ct+=1
    else:
        ct=0
    print(str(x0)+"  "+str(x1)+"  "+str(x2)+"    "+str(z)+"    "+str(round(w0,1))+"  "+str(round(w1,1))+"  "+str(round(w2,1))+"    "+str(round(c0,1))+"  "+str(round(c1,1))+"  "+str(round(c2,1))+"    "+str(round(s,1))+"    "+str(n)+"    "+str(e)+"    "+str(d)+"    "+str(round(m,1))+"  "+str(round(n,1))+"  "+str(round(o,1)))
    if(ct==4):
        break
    w0=m
    w1=n
    w2=o
    if x1==0 and x2==0:
        x1=0
        x2=1
    elif x1==0 and x2==1:
        x1=1
        x2=0
    elif x1==1 and x2==0:
        x1=1
        x2=1
    else:
        x1=0
        x2=0
print()
print("Final Weights are:"+str(round(w0,1))+" "+str(round(w1,1))+" "+str(round(w2,1)))
result=w0+j*w1+k*w2
if(result>0.5):
    print("The NAND of "+str(j)+" and "+str(k)+" is 1.")
else:
    print("The NAND of "+str(j)+" and "+str(k)+" is 0.")
    
    
