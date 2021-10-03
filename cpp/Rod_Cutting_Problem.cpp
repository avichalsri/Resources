#include<bits/stdc++.h>
using namespace std;
#define ln "\n";
#define TC() int t; cin >> t; while(t--)
#define IO() ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)

void solve(){}

// ROD CUTTING PROBLEM IS EXACTLY SAME AS UNBOUNDED KNAPSACK PROBLEM !!!
int main(){

	IO();
	// TC() solve();
	
	int length[] = {1, 2, 3, 4, 5}; 
	int prices[] = {2,4,6}; 
	int n = sizeof(length)/sizeof(length[0]); // size of length[] array
	int N = 5; // (size of rod)

	int dp[n+1][N+1];

	// Step 1: Initialization
	for(int i = 0; i < n+1; i++)  dp[i][0] = 0;
	for(int j = 0; j < N+1; j++)  dp[0][j] = 0;


	// Step 2
	for(int i = 1; i < n+1; i++){
		for(int j = 1; j < N+1; j++){
			if(length[i-1] <= j){
				dp[i][j] = max(prices[i-1] + dp[i][j-length[i-1]] , dp[i-1][j]);
			}
			else dp[i][j] = dp[i-1][j];
		}
	}


	cout << dp[n][N];

	return 0;
}
