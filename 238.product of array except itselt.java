class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        //从左往右，result[i]存的是i之前的所有数的乘积
        for (int i = 1; i < nums.length; i++) {
            //result[i-1]是i－1左边的所有数的乘积（不包括i－1），然后＊nums[i - 1]，就是i之前的所有数的乘积
            result[i] = result[i - 1] * nums[i - 1];
        }
        // 从右往左，right存的是i右边所有的数的乘积，result［i］是最终结果
        // 对于result[nums.length - 1]，只乘以1，因为它的右边没有数字了
        int right = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] *= right;
            right *= nums[j];
        }
        return result;
    }
}