//Improve
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        boolean[] used = new boolean[nums.length];
        helper(nums, result, new ArrayList<>(), used);
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            helper(nums, result, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}


// Original Answer
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        helper(nums, result, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}