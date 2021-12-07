


#include <iostream>
#include <vector>
#include <map>
/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]


Output: Because nums[0] + nums[1] == 9, we return [0, 1].

*/


// π˛œ£”≥…‰
//  ±º‰∏¥‘”∂»: O(n)
// ø’º‰∏¥‘”∂»: O(n)
using namespace std;


class Solution{

public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int l = nums.size();
        map<int,int> map;
        for(int i=0;i<l;++i){
            auto iter = map.find(target-nums[i]);
            if(iter==map.end()){
                map[nums[i]] = i;
            }
            else{
                return{iter->second,i };
            }
        }
        return {};
    }
};

void print_vec(const vector<int>& vec){
    for(int e: vec)
        cout << e << " ";
    cout << endl;
}


int main() {

    vector<int> nums = {2,5,5,11};
    int target = 10;
    print_vec(Solution().twoSum(nums, target));

    return 0;
}
