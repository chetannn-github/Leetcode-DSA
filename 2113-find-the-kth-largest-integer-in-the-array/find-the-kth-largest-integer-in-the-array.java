class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)-> getBiggerNumber(a,b));

        for(String num : nums){
            pq.add(num);
        }
    
        while(--k!=0){
            pq.remove();
        }
        return pq.peek();
    }

    public int getBiggerNumber(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();

        if(l1 != l2) return l2-l1;
        
        for(int i=0; i<l1; i++){
            if(num1.charAt(i) != num2.charAt(i)){
                return (num2.charAt(i)-num1.charAt(i));
            }
        }
        return l1-l2;
    }
}