// The algorithm for shuffle an array is go through the array and generate the random number from 0 to the current index j and swap the two numbers. 
class Solution {
    public int[] origin;
    // public int[] shuffled;
    Random rn;
    
    public Solution(int[] nums) {
        origin = nums;
        // shuffled = nums.clone();
        rn = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = origin.clone();
        if (shuffled == null || shuffled.length == 0) return shuffled;
        int length = shuffled.length;
        for (int i = 0; i < length; i++) {
            int a = rn.nextInt(i + 1);
            swap(shuffled, a, i);
        }
        return shuffled;
    }
    
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}