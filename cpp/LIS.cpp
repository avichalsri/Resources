// Dynamic Programming Approach of Finding LIS by reducing
// the problem to longest common Subsequence

/*
  This is the implementation of LIS problem to find the longest increasing subsequence among the given two array.
  for eg:-
  input :- s1 = [1,2,3,4,5], s2 = [1,3,1,2,3,4]
  output = [1,2,3,4] (length == 4)
*/

#include <bits/stdc++.h>
using namespace std;

/* lis() returns the length of the longest
increasing subsequence in arr[] of size n */
int lis(int arr[], int n)
{
	vector<int> b;
	set<int> s;

	// setting iterator for set
	set<int>::iterator it;

	// storing unique elements
	for (int i = 0; i < n; i++) {
		s.insert(arr[i]);
	}

	// creating sorted vector
	for (it = s.begin(); it != s.end(); it++) {
		b.push_back(*it);
	}
	int m = b.size(), i, j;
	int dp[m + 1][n + 1];

	// storing -1 in dp multidimensional array
	for (i = 0; i < m + 1; i++) {
		for (j = 0; j < n + 1; j++) {
			dp[i][j] = -1;
		}
	}
	// Finding Longest common Subsequence of the two
	// arrays
	for (i = 0; i < m + 1; i++) {
		for (j = 0; j < n + 1; j++) {
			if (i == 0 || j == 0) {
				dp[i][j] = 0;
			}
			else if (arr[j - 1] == b[i - 1]) {
				dp[i][j] = 1 + dp[i - 1][j - 1];
			}
			else {
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}
	return dp[m][n];
}

/* Driver program to test above function */
int main()
{
	int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	int n = sizeof(arr) / sizeof(arr[0]);
	printf("Length of lis is %d\n", lis(arr, n));
}

/* This code is contributed by Arun Bang */
