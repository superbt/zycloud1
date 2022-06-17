package com.zy.zycloud.zyserver.test.t0216;

/**
 * 堆排序 -2022.02.17 构建
 */
public class T5 {


    public static void heapSort(int [] arr){
        int len = arr.length;
        //循环建堆
        for (int i= 0 ;i<len-1;i++){
            buildMaxHeap(arr,len-1-i);
            //交换堆顶和最后一个元素
            swap(arr,0,len-1-i);
        }
    }

    //交换函数
    public static void swap(int[] data ,int i ,int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp ;
    }

    //对data数据从0到lastIndex 构建大顶堆
    private static void buildMaxHeap(int [] data, int lastIndex){
       //从lastIndex初节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k =i ;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左节点的索引
                int biggerIndex = 2+k+1 ;
                //如果biggerIndex小于lastIndex
                //如果biggerIndex+1代表的k节点的右节点等于
                if (biggerIndex<lastIndex){
                    //若右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex ++ ;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
                    k = biggerIndex ;
                }else{
                    break;
                }
            }
        }

    }


    public static void main(String[] args) {
        int [] arr = T_Data.getIntArray();
        T_print.printIntArr(arr);
        Long startTime = System.currentTimeMillis();
        T5.heapSort(arr);
        Long endTime = System.currentTimeMillis();
        T_print.printStr("用时【"+(endTime - startTime)+"】毫秒完成排序");
        T_print.printIntArr(arr);
    }

}
