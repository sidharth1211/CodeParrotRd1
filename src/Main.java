import java.util.*;
// Backtracking
// nums = [1,2,3]

//  HashSet<List<Integer>> result;
//  printSubsetFunction(nums, index, result, new ArrayList<Integer> subset);


// printSubsetFunction(nums, index, result, new ArrayList<Integer> subset){
// if(index == nums.length){
//result.add(subset);
//}
// for(int i= index, i< nums.length){
// subset.add(i);
//printSubset();
// subset.pop();
// recursive call printSubset
//}
//}

//  Time: O(2^n)

public class Main {
    // Helper function
    public static void printSubsetHelper(int[] nums, int index, List<Integer> subset, List<List<Integer>> result){
        result.add(new ArrayList(subset));
        if(index == nums.length)
            return;
        for(int i = index; i<nums.length;i++){
            subset.add(nums[i]);// current subset
            printSubsetHelper(nums, i+1, subset,result);
            subset.remove(subset.size()-1);
        }
    }
    public static void printSubset(int[] nums){

        List<List<Integer>> result = new ArrayList<List<Integer>>(); // List containing all the subsets
        printSubsetHelper(nums,0, new ArrayList<Integer>(), result); // helper function to print recursively the
        // solution

        for (int i = 0; i < result.size(); i++) {
            System.out.printf("[ ");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.printf("%d, ", result.get(i).get(j));
            }
            System.out.printf("] \n");
        }
        return;

    }
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        printSubset(nums);
        return;
    }
}