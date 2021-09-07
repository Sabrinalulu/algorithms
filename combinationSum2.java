// Given a collection of candidate numbers (candidates) and a target number (target), 
// find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
import java.util.*;

public class combinationSum2 {

    public static void main(String args[]){
        int target=8;
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        combinationSum2 ans = new combinationSum2();
        System.out.println(ans.sum2(candidates, target));
    }

    public List<List<Integer>> sum2(int[] candidates, int target){
        int remain = target;
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, remain, comb, output);
        return output;
    }

    public void backtrack(int[] candidates, int cur, int remain, List<Integer> comb, List<List<Integer>> output){
        // base case
        if(remain==0){
            output.add(new ArrayList<Integer>(comb));
            return;
        }else if(remain<0){
            return;
        }

        for(int i=cur; i<candidates.length; i++){
            if(i>cur && candidates[i]==candidates[i-1]) continue;

            comb.add(candidates[i]);
            backtrack(candidates, i+1, remain-candidates[i], comb, output);
            comb.remove(comb.size()-1);
        }
    }
    
}
