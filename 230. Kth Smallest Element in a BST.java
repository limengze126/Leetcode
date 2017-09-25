class Solution {
    public int count = 0;
    public int result = Integer.MIN_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }
    //中序遍历，先走到最下面，再开始往上找，count＋＋，。。。
    public void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        helper(root.right, k);
    }
}