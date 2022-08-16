package 排序算法;

import java.util.Arrays;

public class shell {
    public static void shellSort(int[] arr){
        int len = arr.length;
        int tmp;
        for (int gap = len/2; gap >0 ; gap/=2) {
//            从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < len; i++) {
                // i代表即将插入元素的位置 从gap开始
                // j 代表和i同组的元素
                // 从后往前插入排序
                for (int j = i-gap; j >=0 ; j-=gap) { // 从-gap
                    if (arr[j] > arr[j + gap]){
                        tmp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap]= tmp;
                    }
                }
                }
            }
        }

    public static void main(String[] args) {
        int[] arr = {5,1,2,9,2,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    }

