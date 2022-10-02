#include <iostream>
using namespace std;

int isNumericString(unsigned char *num)
{
	int i=0;
    while (*(num+i)) {
        if (*(num+i) >= '0' && *(num+i) <= '9')
            i++;
        else
            return 0;
    }
    return 1;
}

int main()
{
	int ret = 0;
	unsigned char str1[] = "123";
	unsigned char str2[] = "ABC";
	
	ret = isNumericString(str1);
	if(ret)
		cout<<"It is numeric string"<<endl;
	else
		cout<<"It is not numeric string"<<endl;
	
	ret = isNumericString(str2);
	if(ret)
		cout<<"It is numeric string"<<endl;
	else
		cout<<"It is not numeric string"<<endl;	
	
	return 0;
}
