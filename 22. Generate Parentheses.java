public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, n, "", 0, 0);
        return result;
    }
    
    private void helper(List<String> result, int n, String prefix, int left, int right) {
        if (prefix.length() == n * 2) {
            result.add(prefix);
            return;
        }
        if (left < n) {
            helper(result, n, prefix + "(", left + 1, right);
        }
        if (right < left) {
            helper(result, n, prefix + ")", left, right + 1);
        }
    }
}