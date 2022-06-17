package com.zy.zycloud.zyserver.test.t0216;

public class T3 {



    private static int partition(int []arr ,int low,int high){
        //指定左指针i和右指针j
        int i = low ;
        int j = high ;
        //将第一个数作为基准值，挖坑
        int x = arr[low];
        //使用循环实现分区操作
        while(i<j){
            //1.从右向左移动j,找到第一个
            //小于基准值的arr[j]
            while (arr[j]>=x&&i<j){
                j--;
            }
            //2.将右侧找到小于基准的值，加入到左边的位置，左指针想中间移动一个位置i++
            if(i<j){
                arr[i] = arr[j];
                i++ ;
            }
            //3.从左向右移动i,找到第一个大于等于基准值的值arr[i]
            while(arr[i]<x&&i<j){
                i++;
            }
            //4.将左侧找到的打印等于基准值的值加入到右侧的坑中，右指针向中间移动一个位置 j--
            if(i<j){
                arr[j] = arr[i];
                j-- ;
            }
    }
        //使用基准值的填坑，这就是基准值的最终位置
        arr[i] = x; // arr[j] = y ;
        //返回基准值的位置索引
        return i ;
    }

    private static void quickSort(int [] arr,int low ,int high){
     if(low<high){
         int index = partition(arr,low,high);
         quickSort(arr,low,index -1);
         quickSort(arr,index+1,high);
     }
    }


    public static void quickSort(int[] arr){
        int low = 0 ;
        int high = arr.length -1 ;
        quickSort(arr
        ,low,high);
    }

    public static void main(String[] args) {
        int[]  arr = T_Data.getIntArray();
        T_print.printIntArr(arr);
        T_print.printStr("排序后");
        quickSort(arr);
        T_print.printIntArr(arr);
    }
}
