class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] result = new long[n];
        List<Triplet> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int num1 = nums1[i];
            int num2 = nums2[i];
            list.add(new Triplet(num1, num2, i));
        }

        Collections.sort(list,(a,b)-> (a.num1 - b.num1));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (a-b));
        long maxKSum = 0L;

        for(int i=0; i<n;) {
            int currNum1 = list.get(i).num1;
            long currMaxKSum = maxKSum;

            while(i<n && list.get(i).num1 == currNum1) {
                result[list.get(i).idx] = currMaxKSum;
                
                pq.add(list.get(i).num2);
                maxKSum += list.get(i).num2;
                if(pq.size() > k) {
                    maxKSum -= pq.remove();
                }
                i++;
            }    
            
            
        }
    
        return result;
    }
}

class Triplet {
    int idx, num1, num2;
    Triplet(int num1,int num2, int idx){
        this.num1 = num1;
        this.num2 = num2;
        this.idx = idx;
    }
}