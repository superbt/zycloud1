package ms.strategy;

public class Sorter {

    public static void sort(Comarable[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {

            int minPos = i ;
            for (int j = i+1; j <arr.length ; j++) {
               minPos = arr[j].compareTo(arr[minPos])<0?j:minPos;
            }
            swap(arr,i,minPos);
        }
    }
    private static void swap(Comarable[] arr ,int i ,int j){
        Comarable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp ;
    }
}
