// 1377 Leetcode (https://leetcode.com/problems/frog-position-after-t-seconds/)

class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int k) {
        vector<vector<int>> g(n);
        vector<bool> v(n, false);
        int x, y;
        for(int i=0; i<edges.size(); i++) {
            x = edges[i][0]-1;
            y = edges[i][1]-1;
            g[x].push_back(y);
            g[y].push_back(x);
        }
        k--;
        double p=0;
        
        queue<vector<double>> q;
        vector<double> a;
        q.push({0, (double)t, 1});
        v[0] = true;
        while(!q.empty()) {
            a = q.front();
            q.pop();
            int p1;
            if(a[0] == 0) {
                p1 = g[a[0]].size();
            }
            else {
                p1 = g[a[0]].size()-1;
            }
            
            if(a[0] == k && a[1]>0 && p1>0) {
                p=0;
                break;
            }
            else if(a[0] == k && a[1]>=0) {
                p = a[2];
                break;
            }
            if(a[1] < 0) {
                continue;
            }
            
            a[2] = a[2]/p1;
            for(auto i: g[a[0]]) {
                if(v[i] == false) {
                    q.push({(double)i, a[1]-1, a[2]});
                    v[i] = true;
                }
                
            }
        }
        return p;
    }
};
