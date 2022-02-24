/**

如果时间复杂度log（m+n） 通常都需要二分查找


Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

等价于折半删除查找第K大的数
c: a,b合并后的有序数组
1） a[k/2 - 1] = b[k/2 - 1] , return a[k/2 - 1] or b[k/2 - 1]
2)  a[k/2 -1] > b[k/2 - 1] , 说明 b[0, k/2 -1] 范围内的元素一定比c[k/2 -1]小， 可以不考虑b[0,k/2 - 1]
3)  a[k/2 -1] < b[k/2 -1] ，和（2）相反

递归结束条件：

1) a[k/2 - 1] == b[k/2 - 1] return a[k/2 -1]
2) a或b为空时, b[k/2 -1]或a[k/2-1]
3) k==1时，return min(a[0], b[0])

**/
#include <iostream>
#include <vector>
#include <cassert>

using namespace std;


class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size(), m = nums2.size(), k=0;
        k = (n + m + 1) / 2;
        if( (n+m) % 2 == 0 ){
            // 奇数
            return getK(nums1,0, n -1, nums2, 0 , m -1 , k);
        }
        return getK(nums1,0, n -1, nums2, 0 , m -1, k) + getK(nums1,0, n -1, nums2, 0 , m -1, k + 1) / 2.0;

    }
    int getK(const vector<int>& nums1,int start1, int end1, vector<int>& nums2,int start2, int end2, int k){
        int m = nums1.size(), n = nums1.size();
        if(end1 < start1)
            return nums2[start2 + k];
        if(end2  < start2)
            return nums2[start1 + k];
        if(k==1)
            return min(nums1[start1], nums2[start2] );

        int len1 = end1 - start1 + 1, len2 = end2 - start2 + 1;
        int mid1 = len1 / 2 , mid2 = len2 / 2;
        int e1 = nums1[start1 + mid1] , e2 = nums2[start2 + mid2];


        //if( k = 1)
          //  return min(nums1[start1], nums1[start2]);
        if(e1 < e2){
            return  getK(nums1, start1+ mid1, end1, nums2, start2,end2, k - mid1);
        }
        return getK(nums1, start1, end1, nums2, start1 + mid2, end2, k -mid2);






    }

};




/**

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    int findKth(vector<int>& nums1, int i, vector<int>& nums2, int j, int k) {
        if (i >= nums1.size()) return nums2[j + k - 1];
        if (j >= nums2.size()) return nums1[i + k - 1];
        if (k == 1) return min(nums1[i], nums2[j]);
        int midVal1 = i + k / 2 - 1 < nums1.size() ? nums1[i + k / 2 - 1] : INT_MAX;
        int midVal2 = j + k / 2 - 1 < nums2.size() ? nums2[j + k / 2 - 1] : INT_MAX;
        if (midVal1 < midVal2) return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
};
**/
int main() {

    vector<int> nums11 = {1, 3};
    vector<int> nums12 = {2};
    cout << Solution().findMedianSortedArrays(nums11, nums12) << endl;
    // 2

    vector<int> nums21 = {1, 2};
    vector<int> nums22 = {3, 4};
    cout << Solution().findMedianSortedArrays(nums21, nums22) << endl;
    // 2.5

    vector<int> nums31 = {};
    vector<int> nums32 = {1};
    cout << Solution().findMedianSortedArrays(nums31, nums32) << endl;
    // 1

    vector<int> nums41 = {1, 2, 2};
    vector<int> nums42 = {1, 2, 3};
    cout << Solution().findMedianSortedArrays(nums41, nums42) << endl;
    // 2

    return 0;
}
