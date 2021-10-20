// Question link : https://leetcode.com/problems/add-binary/

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
string addBinary(string a,string b){
  // l1 = length of string a 
  // l2 = Length of string b
     int l1=a.size(),l2=b.size(),carry=0;
     string an;
     // when l1=l2=carry=0 will zero then while loop will terminate  
     while(l1||l2||carry){
      // s1 & s2 is for adding digits
     	int s1,s2; 
     	if(l1){s1=a[l1-1]-'0';l1--;}
     	else s1=0;

     	if(l2){s2=b[l2-1]-'0';l2--;}
     	else s2=0;

     	int sum = s1+s2+carry;

     	if(sum==0){
         an+="0";
         carry = 0;
     	}else if(sum==1){
     		an+="1";
     		carry = 0; 
     	}else if(sum==2){
     		an+="0";
     		carry=1;
     	}
     	else{
         an+="1";
         carry=1;
     	}
    }
     // reverse string 
     string ans;
     for(int i=an.size()-1;i>=0;i--){
      ans+=an[i];
     }
    	return ans; 
  }
};
int main(){

    Solution s;
    string a,b;
    cin>>a>>b;
    cout<<s.addBinary(a,b);

	return 0;
}
