/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Iteration
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }else {
                TreeNode node = stack.pop();
                result.add(node.val);
                curr = node.right;
            }
        }
        return result;
    }
}



//Recursion
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}