#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int mm[30];

int main()
{
	int b[10],n,k=0,i,m,s[10],j=0,flag=0,l,len;
	int ll=1,kk=0,jj=0;
	int a[4][8]={
				{0,0,0,0,0,0,0,0},
				{0,1,0,1,1,1,0,0},
				{0,1,1,0,1,0,1,0},
				{0,0,1,1,1,0,0,1}
				};
	char mess[40];
	//system("clear");
	printf("Enter the message:  ");
	scanf("%s",&mess);
	len = strlen(mess);
	for(i=0;i<len;i++)
	{
		k=mess[i];
		k%=16;
		while(k!=0){
			mm[jj++]=k%2;
			k=k/2;
		}
		while(jj%4!=0)
			mm[jj++]=0;
	}
	k=0;
	while(kk<jj){
		do{
			b[ll++]=mm[kk++];
		}while(kk%4!=0);
		
		ll=1;
		b[5]=(b[1]+b[3]+b[4])%2;
		b[6]=(b[1]+b[2]+b[4])%2;
		b[7]=(b[2]+b[3]+b[4])%2;
		
		printf("\ncodeword of %c\n",mess[k]);
		for(i=1;i<=7;i++)
			printf("%d ",b[i]);
		printf("\n");
		
		printf("\nEnter the codeword recieved by receiver\n");		
		for(i=1;i<=7;i++)
			scanf("%d",&b[i]);
			
		b[0]=0;
		for(m=0;m<=3;m++)
			s[m]=0;
		m=0;
		
		for(i=0;i<=3;i++){
			for(j=0;j<=7;j++)
			{
				s[m]=s[m]+(a[i][j]*b[j]);
				s[m]=s[m]%2;
			}
			m++;
		}
		
		for(i=1;i<=3;i++)
			printf(" %d",s[i]);
		printf("\n");
		
		for(i=1;i<=7;i++)
		{
			for(j=1;j<=3;j++)
			{
				if(s[j]==a[j][i])
					flag=1;				
				else{
					flag=0;
					break;
				}
			}
			if(flag)
			{
				printf("error is at %d\n",i);
				if(b[i])
					b[i]=0;
				else
					b[i]=1;
			}
		}
	printf("Corrected codeword for %c \n",mess[k]);
	for(i=1;i<=7;i++)
		printf("%d ",b[i]);
	printf("\n");
	k++;
	}
}
