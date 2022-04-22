#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        // �ҵ�����߿�ʼ�ݼ���λ�� i �� arr[i-1] > arr[i]
        // �ҵ����ұߵķǵݼ��Ŀ�ʼλ�� j �� arr[k] <= arr[k+1], any k >= j
        int left = 1, right = arr.size()-1, n = arr.size();
        while (left < n && arr[left-1] < arr[left]) ++left;
        while (right-1 >= 0 && arr[right-1] < arr[right]) --right;
        if (left > right) return 0; // �Ѿ�����
        // �м�������� arr[left:right] �϶���Ҫɾ���ģ���Ϊֻ��ɾ��һ��������������
        int ans = right;
        for (int i = 0; i < left; ++i) {
            int e = arr[i];
            int j = lower_bound(arr.begin()+right, arr.end(), e) - arr.begin();
            ans = min(ans, j-i-1);
        }
        return ans;
    }
};

int main(){
    vector<int> num;
    int number;
    while(cin>>number){
        num.push_back(number);
        if(cin.get()=='\n')
            break;
    }
    cout<<Solution().findLengthOfShortestSubarray(num)<<endl;
}
