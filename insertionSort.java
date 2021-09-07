// 有個陣列ex.[4,3,2,10,12,1,5,6] 從index1到底輪流當指標，如果比前面一位小，繼續比之前的(向左)
// 最後移動位置（move greater elements one position up）
public class insertionSort {
    public static void sort(int[] arr){
        for(int i=1; i<arr.length; i++){
            // if(arr[i]<arr[i-1])
            int anchor = arr[i];
            int j = i-1;
            while(j>=0 && anchor<arr[j]){
                arr[j+1] = arr[j]; // move one position up
                j--;
            }
            // 不重排的情況。因為while loop做了j--所以開頭index為-1+1=0
            arr[j+1] = anchor;
        }
    }

    public static void printArr(int[] arr){
        // for(int k=0; k<arr.length; k++){
        //     System.out.print(arr[k]+", ");
        // }
        for(int ele:arr){
            System.out.print(ele+", ");
        }
    }
    public static void main(String args[]){
        int[] arr = new int[]{4,3,2,10,12,1,5,6};
        sort(arr);
        printArr(arr);
    }
}
