//BucketSort + HashMap
//这里的bucket sort，bucket[i]存的是出现过i次的所有Integer
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(entry.getKey());
        }
//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－这里要注意，没写出来－－－－－－－－－－－－－－－－－－－－－－－
        for (int j = bucket.length - 1; j >= 0 && result.size() < k; j--) {
            if (bucket[j] != null) result.addAll(bucket[j]); //------------注意用addAll！！！------
        }
        return result;
    }
}




//  PriorityQueue + HashMap
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        Comparator<Map.Entry> comp = new Comparator<Map.Entry>(){
            public int compare(Map.Entry e1, Map.Entry e2) {
                return (int)e1.getValue() - (int)e2.getValue();
            }
        };
        PriorityQueue<Map.Entry> pq = new PriorityQueue<>(comp);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            }else {
                pq.offer(entry);
                pq.poll();
            }
        }
        while (pq.size() != 0) {
            //不能直接result.add(pq.poll().getKey())!!!
            // Map.Entry<Integer, Integer> entry = pq.poll();
            // result.add(entry.getKey());
            result.add((int)pq.poll().getKey());
        }
        return result;
    }
}