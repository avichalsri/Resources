// C/C++ program to solve fractional Knapsack Problem 
#include <bits/stdc++.h> 

using namespace std; 
struct Item 
{ 
	int value, weight; 
}; 

// Comparison function to sort Item according to val/weight ratio 
bool cmp(struct Item a, struct Item b) 
{ 
	double r1 = (double)a.value / a.weight; 
	double r2 = (double)b.value / b.weight; 
	return r1 > r2; 
} 

// Main greedy function to solve problem 
double fractionalKnapsack(int W, struct Item arr[], int n) 
{ 
	sort(arr, arr + n, cmp); 
	
//	for (int i = 0; i < n; i++) 
//	{ 
//		cout << arr[i].value << " " << arr[i].weight << " : " 
//			<< ((double)arr[i].value / arr[i].weight) << endl; 
//	} 
	

	int curWeight = 0; // Current weight in knapsack 
	double finalvalue = 0.0; // Result (value in Knapsack) 

	// Looping through all Items 
	for (int i = 0; i < n; i++) 
	{ 
		if (curWeight + arr[i].weight <= W) 
		{ 
			curWeight += arr[i].weight; 
			finalvalue += arr[i].value; 
		} 
		else
		{ 
			int remain = W - curWeight; 
			finalvalue += arr[i].value * ((double) remain / arr[i].weight); 
			break; 
		} 
	} 

	// Returning final value 
	return finalvalue; 
} 

// driver program to test above function 
int main() 
{ 
	int W = 50; // Weight of knapsack 
	struct Item I[3];
	
	I[0].value = 60;
	I[0].weight= 30;
	
	I[1].value = 60;
	I[1].weight= 10;
	
	I[2].value = 100;
	I[2].weight= 20;
	
	int n = 3; 

	cout << "Maximum value we can obtain = "<< fractionalKnapsack(W, I, n); 
	return 0; 
} 

