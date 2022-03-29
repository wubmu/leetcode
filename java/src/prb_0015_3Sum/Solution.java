package prb_0015_3Sum;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int l=0, r=array.length - 1;
        while(l<r){
            int mid = (l+r) /2;
            if(l == mid)
                break;
            if(array[mid] > array[l])
                l = mid + 1;
            else
                r = mid;



        }

        return Math.min(array[l],array[r]);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[2];
        a[0]= 4;
        a[1] = 3;
        System.out.println(s.minNumberInRotateArray(a));
    }
}