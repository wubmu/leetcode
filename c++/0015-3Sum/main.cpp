#include <iostream>
#include <vector>
#include <cassert>
#include <stdexcept>

using namespace std;
#include <algorithm>

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        if( n <3){
            return {};
        }

        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;

        for(int i = 0 ; i < nums.size() -2; i++){


            if (nums[i] > 0)
                return ans;

            if (i > 0 && nums[i]==nums[i-1])
                continue;
            int l = i + 1, r = n -1 ;
            while(l < r){

                if(nums[i] + nums[l] + nums[r] == 0){

                    ans.push_back({nums[i],nums[l], nums[r]});
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]) l++;
                    while(l < r && nums[r] == nums[r+1]) r--;
                }else if (nums[i] + nums[l] + nums[r] < 0 ){

                l++;
                }else{
                r--;
                }

            }
        }
    return ans;
    }
};


int main() {

    vector<int> nums1 = {-1, 0, 1, 2, -1, -4};
    vector<vector<int>> res = Solution().threeSum(nums1);
    for( int i = 0 ; i < res.size() ; i ++ ){
        for( int j = 0 ; j < res[i].size() ; j ++ )
            cout<<res[i][j]<<" ";
        cout<<endl;
    }

    return 0;
}
