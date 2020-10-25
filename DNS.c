#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>

int main()
{
	int i,flag=0;
	char buff[80],s1[80],s2[80];
	FILE *fp;
	printf("\nSelect Choice \n\t1.Forward Mode\n\t2.Backward Mode");
	printf("\nYour choice is : ");
	scanf("%d",&i);
	switch(i)
	{
		case 1:
			printf("Enter name of the server: ");
			scanf("%s",buff);
			fp = fopen("dns.txt","r");
			while(!feof(fp)){
				fscanf(fp,"%s",s1);
				fscanf(fp,"%s",s2);
				if(strcmp(s1,buff)==0){
					printf("The IP address of the servere is: %s\n\n",s2);
					flag=1;
				}
				bzero(s1,80);
				bzero(s2,80);
			}
			if(flag==0){
				printf("\nInvalid server name given.\n");
			}
			flag=0;
			bzero(buff,80);
			fclose(fp);
			break;
		
		case 2:
			printf("Enter IP address of the server: ");
			scanf("%s",buff);
			fp = fopen("dns.txt","r");
			while(!feof(fp)){
				fscanf(fp,"%s",s1);
				fscanf(fp,"%s",s2);
				if(strcmp(s2,buff)==0){
					printf("The name of the servere is: %s\n\n",s1);
					flag=1;
				}
				bzero(s1,80);
				bzero(s2,80);
			}
			if(flag==0){
				printf("\nInvalid IP address given.\n");
			}
			flag=0;
			bzero(buff,80);
			fclose(fp);
			break;
		default:
			printf("Thank you for using our service.\n");
			exit(0);
	}
	return 0;
}
