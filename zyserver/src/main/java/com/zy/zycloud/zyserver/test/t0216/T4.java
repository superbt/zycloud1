package com.zy.zycloud.zyserver.test.t0216;

public class T4 {


    public static void sheelSort(int [] arr){
        int len = arr.length ;
        while(len!=0){
            len = len/2 ;
            //分组
            for(int i=0;i<len;i++){
                //元素从第二个开始
                for(int j=i+len;j<arr.length; j=j+len){
                    //k为有序序列最后一位的位数
                    int k = j -len ;
                    int temp = arr[j];//要插入的元素
                    //从后往前遍历
                    while (k>=0&&temp<arr[k]){
                        arr[k+len] = arr[k];
                        k-= len ;//向后移动len位
                    }
                    arr[k+len] = temp ;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = T_Data.getIntArray() ;
        T_print.printIntArr(arr);
        sheelSort(arr);
        T_print.printStr("排序后");
        T_print.printIntArr(arr);
    }

}
