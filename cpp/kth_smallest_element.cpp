#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
    int kthSmallest(int arr[], int l, int r, int k) {
        int n=r+1;
        sort(arr,arr+n);
        return arr[k-1];
    }
};
 
int main()
{
    int test_case;
    cout<<"Enter number of test cases"<<endl;
    cin>>test_case;
    while(test_case--)
    {
        int number_of_elements;
        cout<<"Enter number of elements"<<endl;
        cin>>number_of_elements;
        int a[number_of_elements];
        cout<<"Enter the elements"<<endl;
        for(int i=0;i<number_of_elements;i++)
            cin>>a[i];
        int k;
        cout<<"Enter the Kth element"<<endl;
        cin>>k;
        Solution ob;
        cout<<"The Kth smallest element is"<<endl;
        cout<<ob.kthSmallest(a, 0, number_of_elements-1, k)<<endl;
    }
    return 0;
}

