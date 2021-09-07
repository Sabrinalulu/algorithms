import java.util.*;

public class closestP {
    
    public static void main(String[] args){
        int top = 2;
        int[][] input = new int[][]{{-2,2},{3,3},{2,-4}};
        closestP ob = new closestP();
        // integer, String, byte and two dimensional array using toString() and deepToString() method of java.util.Arrays class
        System.out.println(Arrays.deepToString(ob.found(input, top)));
    }

    public int[][] found(int[][] points, int k){
        // 輸入的是一個點[,]，因此pow算的就要是index中的值。要做的是min heap
        PriorityQueue<int[]> ordered = new PriorityQueue<>(Comparator.comparingDouble(value -> -Math.sqrt(Math.pow(value[0],2)+Math.pow(value[1],2))));
        for(int[] point: points){
            ordered.add(point);
            if(ordered.size()>k){
                ordered.poll();
            }
        }

        int[][] result = ordered.toArray(new int[k][2]);
        return result;
    }
}
