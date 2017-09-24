//用binary search找到中间大小的数，然后再for循环找他的位置
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) return -1;
        int n = matrix[0].length;
        int start = matrix[0][0], end = matrix[m - 1][n - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            int i = 0, j = 0;
            for (; i < m - 1; i++) {
                if (matrix[i][0] > mid) {
                    for (; j < n - 1; j++) {
                        //第i行第一个都大于mid了，所以要从第i－1行找
                        if (matrix[i - 1][j] > mid) {
                            count += i * (n - 1) + j; // j is index,j = 3 means 4th num > mid,so count+=j but not count+=j-1
                            break;
                        }
                        break;
                    }
                }
            }
            if (count == k) {
                return matrix[i - 1][j - 1];
            }else if (count > k) {
                end = mid + 1;
            }else {
                start = mid - 1;
            }
        }
        return start;
    }
}