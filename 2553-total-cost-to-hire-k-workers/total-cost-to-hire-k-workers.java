class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int start = 0;
        
        int end = costs.length - 1;
        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> back = new PriorityQueue<>();

        for(int i=0; i<candidates; i++){
            front.add(costs[i]);
            start++;
        }

        for(int i=0; i<candidates && end >= start; i++){
            back.add(costs[end]);
            end--;
        }
        // System.out.println(front.toString() + "===>" + back.toString());
        long cost = 0;
        while(k-->0){
            int frontChoice = front.isEmpty() ? Integer.MAX_VALUE : front.peek() ;
            int backChoice = back.isEmpty() ? Integer.MAX_VALUE : back.peek() ;

            if(frontChoice <= backChoice){
                cost += front.remove();
                if(start <= end) front.add(costs[start]);
                start++;


            }else {
                cost += back.remove();
                if(end >= start) back.add(costs[end]);
    
                end--;
            }


        }

        return cost;
    }
}