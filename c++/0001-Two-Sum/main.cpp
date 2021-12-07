

#include <iostream>
#include <vector>

/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]


Output: Because nums[0] + nums[1] == 9, we return [0, 1].

*/


// 暴力求解
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)
using namespace std;


class Solution{

public:
    vector<int> twoSum(vector<int>& nums, int target){

        for(int i = 0 ; i< nums.size()-1 ; i++){

            for(int j = 1 ; j < nums.size() ; j ++)
                if(nums[i] + nums[j] == target && i!=j)
                    return{i, j};
        }

        throw invalid_argument("the inputs has no solution");

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
