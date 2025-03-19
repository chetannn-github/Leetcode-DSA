class Solution {
    public int lastStoneWeight(int[] stones) {
        // first thought was kii sort krke stack me daal du pr usme me dynamically change nii krr paaugaa orderr
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return b-a;});

        for(int wt : stones){
            pq.add(wt);
        }

        while(!pq.isEmpty()){
            int first = pq.remove();
            if(pq.isEmpty()) return first;

            int second = pq.remove();

            if(first - second != 0){
                pq.add(Math.abs(first - second));
            }
        }

        return 0;
    }
}