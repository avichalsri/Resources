//This program will find out the max sub array sum in O(N)
#include <iostream>
#include <climits>

using namespace std;

int main()
{
	int n;
	cin >> n;
	int arr[n];
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	int currSum = 0, mx = INT_MIN;
	for (int i = 0; i < n; i++)
	{
		currSum += arr[i];
		if (currSum < 0)
		{
			currSum = 0;
		}
		mx = max(currSum, mx);
	}
	cout << mx << endl;

	return 0;
}