class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(events[a][0] != events[b][0]){
                return events[a][0] - events[b][0];
            }else if(events[a][1] != events[b][1]){
                return events[a][1] - events[b][1];
            }
            return a - b;
        });

        for(int i=0; i<events.length;i++){
            pq.add(i);
        }

        PriorityQueue<Integer> pendingEvents = new PriorityQueue<>((a,b)->{
            // kon jaldii end hone walaa
            if(events[a][1] != events[b][1]){
                return events[a][1] - events[b][1];
            }else if(events[a][0] != events[b][0]){
                return events[a][0] - events[b][0];
            }
            return a-b;
        });
        
        int ans = 0;
        int currDay = 1;
        int idx = 0;

        while(true){
            if(pq.isEmpty() && pendingEvents.isEmpty()){
                break;
            }
    
            if(!pq.isEmpty() && pendingEvents.isEmpty()){
                pendingEvents.add(pq.remove());
                currDay = events[pendingEvents.peek()][0];
            }
            int currTaskIdx = pendingEvents.remove();

            if(currDay <= events[currTaskIdx][1]){
                // System.out.println(currTaskIdx + " -> " + currDay);
                ans++;
                currDay++;
                
            }

            
            while(!pq.isEmpty() && currDay >= events[pq.peek()][0]){
                pendingEvents.add(pq.remove());
            }

        }

        return ans;
    }
}