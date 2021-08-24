// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
import java.util.*;
public class Sum2 {

    public int[] summationOf2(int[] input, int target){
        // ele = target-nums[idx]
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<input.length; i++){
            int tmp = target - input[i];
            if(!map.containsKey(tmp)){
                map.put(input[i], i); // stores index in the value
            }else{
                return new int[] { map.get(tmp), i };
            }
        }

        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     System.out.println("key: "+entry.getKey()+"; value: "+entry.getValue());
        // }   

        return null;
    }

    public static void main(String args[]){
        Sum2 object = new Sum2();
        int[] nums = {7,2,15,11};
        int target = 9;
        System.out.print(Arrays.toString(object.summationOf2(nums, target)));
    }
    
}
