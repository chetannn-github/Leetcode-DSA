class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a ));
        int n = nums1.length;

        for(int i=0; i<n; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            if(diff>0) freqMap.put(diff,freqMap.getOrDefault(diff,0)+1);
            
        }

        for(int key : freqMap.keySet()){
            pq.add(key);
        }

        int totalOps = k1 + k2;
        
        while(totalOps != 0 && !pq.isEmpty()){
            int max = pq.remove();
            if(max<=0) break;
            int freq = freqMap.get(max);
            
            if(freq <= totalOps){
                freqMap.remove(max);
                freqMap.put(max-1,freqMap.getOrDefault(max-1,0) + freq);
                
                if(pq.isEmpty() || pq.peek() != max-1) pq.add(max-1);
                totalOps -= freq;

            }else{
                freqMap.put(max,freq-totalOps);
                if(max>0) freqMap.put(max-1,freqMap.getOrDefault(max-1,0) + totalOps);
                

                // pq.add(max-1);
                // pq.add(max);
                totalOps = 0;
            }
        }
        long ans = 0;
        for(int key : freqMap.keySet()){
            long currDiffSquare = (long) key * key; 
            // System.out.println(key + "-> " + freqMap.get(key)) ;
            long totalCurrDiffSquare = currDiffSquare * (long) freqMap.get(key);
            ans += totalCurrDiffSquare;
           
        }

        return ans;
    }
}