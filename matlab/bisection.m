y=@(x) x*sin(x)-1;
x1=input('Enter the value of x1:');
x2=input('Enter the value of x2:');
if y(x1)*y(x2)>0
    fprintf('No root exist within the given interval\n')
    return
end
if y(x1)==0
    fprintf('x1 is one of the root\n')
    return
else if y(x2)==0
        fprintf('x2 is one of the root\n')
        return
    end
end
    for i=1:100
        xn=(x1+x2)/2;
        if y(x1)*y(xn)<0
            x2=xn;
        else
            x1=xn;
        end
        if abs(y(x1))<1.0E-6
            break
        end
    end
    fprintf('The roots : %f\n  The number of bisection: %d\n',x1,i);

        