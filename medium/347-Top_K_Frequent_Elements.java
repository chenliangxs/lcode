/**
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
**/

public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> count = new HashMap<>();
    for(int i : nums) {
        count.put(i, count.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
        public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
            return m1.getValue() - m2.getValue();   //use min heap to store k entries in the heap
        }
    });
    for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
        pq.offer(entry);
        if(pq.size() > k) {
            pq.poll();
        }
    }
    while(!pq.isEmpty()) {
        res.add(pq.poll().getKey());
    }
    return res;
}
