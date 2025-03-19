class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            int l1 = a.length();
            int l2 = b.length();

            if(l1!= l2) return l2-l1;
            
            for(int i=0; i<l1; i++){
                if(a.charAt(i) != b.charAt(i)){
                    return (b.charAt(i)-a.charAt(i));
                }
            }
            return l1-l2;

        });

        for(String num : nums){
            pq.add(num);
        }
    
        while(--k!=0){
            pq.remove();
        }
        return pq.peek();
    }
}