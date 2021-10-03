T=int(input())
while(T!=0):
    C=int(input())
    if(C==0 or C==1 or C==2):
        print(0)
    else:
        m=0
        for d in range(0,C):
                limit=pow(2,d)
                if(limit>C):
                    m=d
                    break
            
        b=(pow(2,m-1))-1
        a=limit-C+b
        print(a*b)
    T=T-1
