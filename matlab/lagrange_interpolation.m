X=[5 7 11 13 17];
Y=[150 392 1492 2366 5202];
n=length(X)-1;
xp=9;
sm=0;
for i=1:n+1
    pr=1;
    for j=1:n+1
        if j~=i
            pr=pr*((xp-X(j))/(X(i)-X(j)));
        end
    end
    sm=sm+Y(i)*pr;
end
yp=sm;
yp