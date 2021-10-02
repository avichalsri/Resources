#include<stdio.h>
#include<string.h>

int l,k,n;

void bsum(char a[],char b[])
{
		int i,j,length=k;
		char sum[length];
		char carry='0';
        
		for(i=length-1;i>=0;i--)
        {
			if(a[i]=='0' && b[i]=='0' && carry=='0')
            {
                b[i]='0';
                carry='0';
            }
            else if(a[i]=='0' && b[i]=='0' && carry=='1')
            {
                b[i]='1';
                carry='0';
 
            }
            else if(a[i]=='0' && b[i]=='1' && carry=='0')
            {
                b[i]='1';
                carry='0';
 
            }
            else if(a[i]=='0' && b[i]=='1' && carry=='1')
            {
                b[i]='0';
                carry='1';
 
            }
            else if(a[i]=='1' && b[i]=='0' && carry=='0')
            {
                b[i]='1';
                carry='0';
 
            }
            else if(a[i]=='1' && b[i]=='0' && carry=='1')
            {
                b[i]='0';
                carry='1';
 
            }
            else if(a[i]=='1' && b[i]=='1' && carry=='0')
            {
                b[i]='0';
                carry='1';
 
            }
            else if(a[i]=='1' && b[i]=='1' && carry=='1')
            {
                b[i]='1';
                carry='1';
 
            }
            else
            	break;
        }
        if(carry=='1'){
        	char temp[length];
        	for(j=0;j<length-1;j++)
        		temp[j] = '0';
        	temp[j] = '1';
        	bsum(temp,b);
		}
		return;
        
	}

int main()
{
	
	int i,j,x=0;
	printf("Enter the length of the data:  ");
	scanf("%d",&l);
	char data[l],rdata[l];
	printf("\nEnter the data to be transmitted:  ");
	scanf("%s",&data);
	printf("\nEnter the length of one segment:  ");
	scanf("%d",&k);
	n = l/k;
	char segment[n][k];
	
	//Dividing the data into segments
	for(i=0;i<n;i++)
		for(j=0;j<k;j++)
			segment[i][j] = data[x++];
	
	//Adding the segments one by one
	char a[k],b[k],c[k],d[k];
	
	for(i=0;i<n-1;i++){
		for(j=0;j<k;j++){
			a[j] = segment[i][j];
			b[j] = segment[i+1][j];
		}
		bsum(a,b);
		for(j=0;j<k;j++)
			segment[i+1][j] = b[j];
	}
	
	//Taking the complement of the sum
	for(j=0;j<k;j++)
	{
		if(b[j]=='0')
			b[j] = '1';
		else
			b[j] = '0';
	}
	printf("\n||>>  Checksum : %s <<||",b);
	
	printf("\n\n\nEnter the received data:  ");
	scanf("%s",&rdata);
	
	//Dividing the data into segments
	x=0;
	for(i=0;i<n;i++)
		for(j=0;j<k;j++)
			segment[i][j] = rdata[x++];
	
	
	for(i=0;i<n-1;i++){
		for(j=0;j<k;j++){
			c[j] = segment[i][j];
			d[j] = segment[i+1][j];	
		}
		bsum(c,d);
		for(j=0;j<k;j++)
			segment[i+1][j] = d[j];
	}
	bsum(b,d);
	for(i=0;i<k;i++)
	{
		if(d[i]=='0')
			d[i] = '1';
		else
			d[i] = '0';
	}
	int checker=0;
	printf("Checksum: ");
	for(i=0;i<k;i++){
		printf("%c",d[i]);
		if(d[i]=='1')
			checker=1;
	}
	
	if(checker)
		printf("\n||>>  Error in data transmission!  <<||\n");
	else
		printf("\n||>>  Data transmission sussessful!  <<||\n");
}











