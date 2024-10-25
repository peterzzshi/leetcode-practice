import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(final int[] nums) {

        final List<List<Integer>> result = new ArrayList<>();

        this.backtrack(nums, new ArrayList<>(), 0, result);
        return result;
    }


    private void backtrack(final int[] nums, final List<Integer> current, final int start, final List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            this.backtrack(nums, current, i + 1, result);
            current.removeLast();
        }
    }
}