/**

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


πÈ≤¢≈≈–Ú



**/


class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size(), k = 0, i = 0, j = 0;
        vector<int> sub(m + n, 0);
        while (i < m && j < n)
            sub[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        while (i < m) sub[k++] = nums1[i++];
        while (j < n) sub[k++] = nums2[j++];
        return k % 2 ? sub[k / 2] : (sub[k / 2] + sub[k / 2 - 1]) / 2.0; // ≈–∂œ∆Ê≈º
    }
};
