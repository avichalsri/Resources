file1=open("validation.txt","r")
t=int(file1.readline())
for _ in range(t):
    p=str(file1.readline())
    n,k,w=map(int,p.split())
    p=str(file1.readline())
    l=list(map(int,p.split()))
    p=str(file1.readline())
    al,bl,cl,dl=map(int,p.split())
    p=str(file1.readline())
    h=list(map(int,p.split()))
    p=str(file1.readline())
    ah,bh,ch,dh=map(int,p.split())
    for i in range(n-k):
        l.append(((al*l[-2]+bl*l[-1]+cl)%dl)+1)
        h.append(((ah*h[-2]+bh*h[-1]+ch)%dh)+1)
    rect=[]
    for i in range(n):
        rect.append([l[i],l[i]+w,h[i]])
    d={}
    p=[]
    ans=0
    for ele in rect:
        for j in range(ele[0],ele[1]):
            if((j+0.5) in d.keys()):
                if(ele[2]>d[j+0.5][0]):
                    ans-=d[j+0.5][1]
                    val=0
                    if((j-0.5) in d.keys()):
                        val=2*min(ele[2],d[j-0.5][0])
                    d[j+0.5]=[ele[2],2*(ele[2]+1)-val]
                    ans+=d[j+0.5][1]
                    q=j+1.5
                    while(q in d.keys()):
                        ans-=d[q][1]
                        val=(d[q][0]+1)*2-2*min(d[q][0],d[q-1][0])
                        ans+=val
                        d[q][1]=val
                        q+=1           
            else:
                val=0
                if((j-0.5) in d.keys()):
                    val=2*min(ele[2],d[j-0.5][0])
                d[j+0.5]=[ele[2],2*(ele[2]+1)-val]
                ans+=d[j+0.5][1]
        p.append(ans)
    res=1
    for e in p:
        res=(res*e)%1000000007
        
    file2=open("hd2.txt","a")
    file2.write("Case #"+str(_+1)+": "+str(res)+"\n")
    file2.close()
    
                    
                        
        
