#include<iostream>
#include<vector>
#include<map>
#include<limits.h>
using namespace std;

class Solution{
public:
    int FindMin(vector<int>&nums){
        int res = -1;
        map<int,int> mp;
        mp.clear();
        for(auto it : nums){
            mp[it]++;
        }

        for(auto it : mp){
            if(it.second==1){
                res = it.first;
                break;
            }
        }
        
        return res;
    }
};

int main(){
    int T,n,a;
    vector<int>num;
    cin>>T;
    while(T--){
        num.clear();
        cin>>n;
        for(int i=0;i<n;i++){
            cin>>a;
            num.push_back(a);
            if (cin.get()=='\n')
                break;
        }
        cout<<Solution().FindMin(num)<<endl;
    }
}
