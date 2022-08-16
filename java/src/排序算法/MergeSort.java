package 排序算法;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int arr[], int left, int right){
        if (arr == null || arr.length<2)
            return;
        if (left < right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr, left, mid,right);
        }
//        int mid = left + (right-left)/2;

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];
        int i = left;  // 左边的索引
        int j = mid+1; // 右边的索引
        int index = 0; // 临时数组索引

        while (i <= mid && j <= right ){
            if (arr[i] <= arr[j])
                tmp[index++] = arr[i++];
            else tmp[index++] = arr[j++];
        }
        //
        while (i <= mid) tmp[index++] = arr[i++];
        while (j <= right) tmp[index++] = arr[j++];

        for (int k = 0; k < tmp.length; k++) {
            arr[left+k] = tmp[k];
        }

    }

    public static void main(String[] args) {
        int[] arr = {5,1,11,2,9,2,0};
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
