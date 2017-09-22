public class Avg{
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,4,3,100,5,4,1000000000};
		System.out.println(verify(nums));
		System.out.println(getAvg(nums));
	}

	public static int getAvg(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int count = 0;
		int sum = 0;
		int avg = 0;
		for (int num : nums) {
			sum += num;
			count++;
			avg = sum / count;
		}
		return avg;
	}

	public static int verify(int[] nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		return sum / nums.length;
	}
}