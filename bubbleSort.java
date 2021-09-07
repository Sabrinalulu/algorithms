public class bubbleSort {
    public static void sort(int[] arr){
        int n = arr.length;
        // tracing every element => make sure all passes finish
        for(int i=0; i<n; i++){
            // moving pointer; let current j swap with j+1 if j+1 is smaller
            // compared to j, j+1 ,so j<n-i-1
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    public static void printArr(int[] arr){
        for(int ele: arr){
            System.out.print(ele+", ");
        }

    }
    public static void main(String args[]){
        int[] arr = new int[]{5,1,4,2,8};
        sort(arr);
        printArr(arr);
    }
    
}
