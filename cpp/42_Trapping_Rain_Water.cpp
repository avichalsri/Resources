//Leetcode problem no 42 (https://leetcode.com/problems/trapping-rain-water/)

class Solution {
public:
    int trap(vector<int>& h) {
        if(h.size()<3) {
            return 0;
        }
        int n=h.size(), c=0;
        vector<int> l(n), r(n);
        l[0]=h[0];
        for(int i=1; i<n; i++) {
            l[i] = max(l[i-1], h[i]);
        }
        r[n-1]=h[n-1];
        for(int i=n-2; i>=0; i--) {
            r[i] = max(r[i+1], h[i]);
        }
        for(int i=1; i<n-1; i++) {
            c += (min(l[i], r[i]) - h[i]);
        }
        return c;
    }
};
