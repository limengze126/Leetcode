//key存的是Ai＋Bj，value存的是出现这个数的次数
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                //如果有多种可能使得A[i] + B[j]＝sum，都要放入map中
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int cd = 0 - C[i] - D[j];
                //如果cd在map中，说明sum＋cd＝0，而map.get(sum)说明了有多少种可能得到sum，所以是result＋＝map.get(sum)
                //比如A，B中有三种组合得到sum，那么每找到一个cd使得sum＋cd＝0，总的组合数量应该加3.
                // EG:A1+B2, A2+B3, A3+B4都等于－1（sum），然后-(C1+D5) = -1（cd），则总的组合方法是3
                result += map.getOrDefault(cd, 0);
            }
        }
        return result;
    }
}