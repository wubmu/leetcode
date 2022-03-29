/**
�����������Դ�������ˮ��

˫ָ�뷨
area = min(h[i],[j]) * (j-i)

d = j- i

�ƶ�������d�϶�����1��

�ƶ��̵�һ�ߣ�min(h[i],[j])���ܱ�� area���ܱ��
�ƶ�����һ�ߣ� min(h[i],[j]) ������߼���,һ������
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
