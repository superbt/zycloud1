package com.zy.zycloud.zyserver.test.t0216;

import java.util.Arrays;

/**
 * 归并排序原理
 *  还是这是个顺序打乱的数字，归并排序采用经典的分治策略，分得阶段就是将问题分成一些小的问题，递归求解
 *  治就是将分得阶段得到的答案合并到一起，
 *  第一步我把这是个数分为两个长度为五的子序列
 *  第二步对这两个子序列在分别采用归并排序
 *  第三步将排序好的两个子序列合并成一个最终的排序序列
 *
 */

public class T6 {

    //合并函数排序
    public static int[] mergeSort(int[] arr){
       if (arr.length<2) {
           return arr;
       }
       int mid = arr.length/2 ;
       int [] left = Arrays.copyOfRange(arr,0,mid);
       int [] right = Arrays.copyOfRange(arr,mid,arr.length);
       return merge(mergeSort(left),mergeSort(right));
    }
    //合并函数
    public static int[] merge( int[] left,int [] right){

        int [] result = new  int[left.length+right.length];
        for(int index =0 ,i=0 ,j=0; index <result.length;index++){
            if(i>=left.length){
                result[index] = right[j++] ;
            }else if(j>=right.length){
                result[index] = left[i++];
            }else if(left[i]>right[j]){
                result[index] = right[j++];
            }else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = T_Data.getIntArray();
        T_print.printIntArr(arr);
        Long startTime = System.currentTimeMillis();
         int[] resArr = T6.mergeSort(arr);
        Long endTime = System.currentTimeMillis();
        T_print.printStr("用时【"+(endTime - startTime)+"】毫秒完成排序");
        T_print.printIntArr(resArr);
    }

}
