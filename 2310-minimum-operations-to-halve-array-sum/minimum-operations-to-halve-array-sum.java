class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b,a);
        });
        double sum = 0;

        for(int val : nums){
            pq.add((double) val);
            sum += val;
        }
        double half = sum/2;
        int ops = 0;
        while(sum > half){
            double max = pq.remove();
            double remove = max/2;
            
            pq.add(max-remove);
            sum = sum -remove;
            ops++;
        }
        return ops;
     
    }
}