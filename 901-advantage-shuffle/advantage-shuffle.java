class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        Arrays.sort(nums1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(nums2[a] - nums2[b]));
        HashSet<Integer> notAddedIdx = new HashSet<>();

        Arrays.fill(result,-1);
        

        for(int i=0; i<n; i++) {
            pq.add(i);
            notAddedIdx.add(i);
        }

        int idx = 0;
        
        
        while(!pq.isEmpty() && idx < n) {
            int currIdx = pq.remove();
            while(idx <n && nums1[idx] <= nums2[currIdx]) {
                idx++;
            }

            if(idx < n) {
                result[currIdx] = nums1[idx];
                notAddedIdx.remove(idx);
                idx++;
            }
        }

        List<Integer> notAddedIdxList = new ArrayList<>(notAddedIdx);
        idx = 0;

        for(int i=0; i<n; i++) {
            if(result[i] == -1) {
                result[i] = nums1[notAddedIdxList.get(idx++)];
            }
        }



        return result;

    }


    
}