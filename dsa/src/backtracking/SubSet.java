package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public static void main(String[] args) {
        int[] nums = {1 , 2, 3 , 4};
        SubSet subSet = new SubSet();
        subSet.subsets(nums);
    }
     public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backTrack(subsets , subset , 1 ,nums.length-1 , nums);
        for(int i = 0 ; i<nums.length -1 ; i++){
            subset.add(i);
        }
        subsets.add(subset);
        return subsets;
    
    }

    public void backTrack(List<List<Integer>> subsets , List<Integer> subset , int start ,int end , int[] nums){
        if(start > end){
            System.out.println(subset);
            subsets.add(new ArrayList<Integer>(subset));
            return;
        }

        for(int i = start ; i<=end ; i++){
            subset.add(nums[i]);
            backTrack(subsets , subset , i+1 , end , nums);
            subset.remove(subset.size()-1);

        }
    }
}
