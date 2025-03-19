class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        long sum = 0;
        for(int gift : gifts){
            pq.add(gift);
            sum += gift;
        }

        while(k!=0){
            int max = pq.remove();
            int root = (int) Math.sqrt(max);
            pq.add(root);
            sum += (root - max);
            k--;
        }

        return sum;
    }
}