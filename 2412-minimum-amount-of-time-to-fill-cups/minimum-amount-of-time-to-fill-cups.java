class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (b-a));
        for(int i=0; i<3; i++) if(amount[i] > 0) pq.add(amount[i]);
        int totalTime = 0;


        while(!pq.isEmpty()) {
            if(pq.size() >= 2) {
                int max = pq.remove();
                int secondMax = pq.remove();
                if(max > 1) pq.add(max-1);
                if(secondMax > 1 ) pq.add(secondMax -1);
            }else {
                totalTime += pq.peek();
                break;
            }
            totalTime++;
        }

        return totalTime;
    }
}