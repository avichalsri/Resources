height=list(map(int,input().split()))
t=[i for i in range(1,len(height)+1)] #t=1,2,3,4,5,6,7,8,9


i,j=0,len(height)-1
area=0
flag=0
while(i!=j):
    area=max(min(height[i],height[j])*(t[j]-t[i]),area)
    if height[i]>height[j]:  ## agr left>right to right-1(j-1)
        j-=1                  ## agr  right>left to left+1(i+1)
    else:
        i+=1
print(area)
