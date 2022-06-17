package com.zy.zycloud.zyserver.test.t0216;

import java.util.Arrays;

public class T2 {

    public static  int[] insertSoft(int [] arr){
        int[] result = arr ;
        int temp;
        int times = 0 ;
        for(int i=1;i<result.length;i++){
            if(result[i]<result[i-1]){
                temp = result[i];
                for(int j=i;j>=0;j--){
                    times++;
                    if(j>0&&result[j-1]>temp){
                        result[j] = result[j-1];
                    }else{
                        result[j] = temp ;
                        break;
                    }
                }
                T_print.printIntArr(arr);
            }
        }
        return result ;
    }

    public static void main(String[] args) {
        int [] arr = T_Data.getIntArray();
        int [] result = insertSoft(arr);
        T_print.printStr("输出结果");
        T_print.printIntArr(arr);
    }
}
