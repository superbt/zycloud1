package com.zy.zycloud.zyserver.test.t0216;

import java.util.Arrays;

public class T1 {
    /**
     * 循环2次 一次全局循环
     *        一次局部循环
     *        上一位和本次位比较 ，如果符合某个条件比如大于则交换位置，不满足，则不进行处理
     * @param a
     * @return
     */
    public static int[] selectSort( int[] a){
        int [] result = a ;
        int temp ;
        int times = 0;
        for(int i=0;i<result.length;i++){
          for(int j=i+1;j<result.length;j++){
             if(result[i]>result[j]){
                 temp = result[i];
                 result[i] = result[j];
                 result[j] = temp ;
             }
          }
          System.out.println(Arrays.toString(result));
        }

        return result ;

    }

    public static void main(String[] args) {
        int [] arr = T_Data.getIntArray();
        int [] softed = selectSort(arr);
        System.out.println("result:"+Arrays.toString(softed));
    }

}
