/**
返回容器可以储存的最大水量

双指针法
area = min(h[i],[j]) * (j-i)

d = j- i

移动过程中d肯定减少1：

移动短的一边，min(h[i],[j])可能变大， area可能变大
移动长的一边， min(h[i],[j]) 不变或者减少,一定减少
**/

class Solution {
public:
    int maxArea(vector<int>& height) {
        int area = 0, i=0, j= height.size()-1;
        while(i<j){
            int tmpArea = min(height[i],height[j]) * (j-i);
            area =  max(area,tmpArea);
            if(height[i]< height[j]){
                i++;
            }else{
                j--;
            }

        }

        return area;
    }
};
