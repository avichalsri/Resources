X=[1891 1901 19 1921 1931];
Y=[46 66 6 93 101];
x=1895;
n=5;
h=X(2)-X(1);
t=(x-X(n))/h;
y=Y(n);
for i=1:n-1
    d(i,1)=Y(i+1)-Y(i);
end
for j=2:n-1
    for i=1:n-j
        d(i,j)=d(i+1,j-1)-d(i,j-1);
    end
end
s=1;q=1;
for k=1:n-1
    s=s*(t+k-1);
    q=q*k;
    y=y+(s/q)*d(n-k,k);
end
y