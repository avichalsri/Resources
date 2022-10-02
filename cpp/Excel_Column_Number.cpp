// Excel Column Number leetcode problem 
// link : https://leetcode.com/problems/excel-sheet-column-number/

class Solution {
public:
    int titleToNumber(string columnTitle) {
        long long sum = 0;
	int c=26;
	int size = columnTitle.size();
	for(int i=0;i<columnTitle.size();i++){
		size --;
        sum += (columnTitle[i] - 'A' + 1) * pow(c,size);	
	}
	return sum;
    }
};
