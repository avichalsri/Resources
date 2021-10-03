/*
Problem Statement-
	John is at a toy store help him pick maximum number of toys. 
	He can only select in a continuous manner and he can select only two types of toys.
	
	// This question is similar to "Longest substring with K unique characters"
	In this ques, maximum John can select only two types of toys or
	u can say the value of K is 2.
  
  Concept used is sliding window technique.
*/


#include<bits/stdc++.h>
using namespace std;

int main(){

	string s = "abaccab";

	int i = 0, j = 0;
	int mx = INT_MIN;
	unordered_map<char,int> m;

	while(j < s.size()){
		m[s[j]]++;
		if(m.size() < 2) j++; // max 2 toys u can pick

		else if(m.size() == 2){
			mx = std::max(j-i+1, mx);
			j++;
		}
		else if(m.size() > 2){
			while(m.size() > 2){
				m[s[i]]--;
				if(m[s[i]] == 0) m.erase(s[i]);
				i++;
			}
			j++;
		}
	}	
	cout << mx << endl;

	return 0;
}
