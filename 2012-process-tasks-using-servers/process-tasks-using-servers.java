// class Solution {
//     public int[] assignTasks(int[] servers, int[] tasks){
//         HashMap<Integer,List<Integer>> futureServers = new HashMap<>();
//         Queue<Integer> freeServers = new LinkedList<>();

//         PriorityQueue<Integer> pq = new PriorityQueue<>(
//             (a,b)->(servers[a] == servers[b] ? a - b : servers[a] - servers[b])
//         );

//         for(int i=0; i<servers.length; i++){
//             pq.add(i);
//         } 
//         int[] results = new int[tasks.length];
        
//         for(int currTime = 0,currTaskIndex = 0; currTaskIndex < tasks.length; currTime++){
//             int gotFreeServer = 0;
//             if(futureServers.containsKey(currTime)){
//                 gotFreeServer = futureServers.get(currTime).size();
//                 for(int taskIndices : futureServers.get(currTime)){
//                     pq.add(taskIndices);
//                 }
//                 futureServers.remove(currTime);
//             }
//             if(currTime < task.length) freeServers.add(currTime);
//             if (pq.isEmpty()) {continue;}

//             while(!freeServers.isEmpty() && !pq.isEmpty()){
//                 int serverAssignedIdx = pq.remove();
//                 int nextTimeFree = currTime + tasks[freeServers.remove()];
//                 results[currTaskIndex++] = serverAssignedIdx;

//                 List<Integer> futureServersList = futureServers.getOrDefault(nextTimeFree,new ArrayList<>());
//                 futureServersList.add(serverAssignedIdx);
//                 futureServers.put(nextTimeFree,futureServersList); 
//             }            
//         }
//         return results;
//     }
// }

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks){
        int n = tasks.length;
        int[] result = new int[n];

        PriorityQueue<Integer> freeServers = new PriorityQueue<>((a,b)-> {
            return servers[a] == servers[b] ? a - b : servers[a] - servers[b] ;
        });
        PriorityQueue<Pair> runningServers = new PriorityQueue<>((a,b)->{
            return (int) (a.endTime - b.endTime);
        });

        int currTaskIdx = 0;
        long currTime = 0;

        for(int i=0; i<servers.length; i++) freeServers.add(i);


        while(currTaskIdx < n) {
            
            while (!runningServers.isEmpty() && runningServers.peek().endTime <= currTime) {
                int serverIdx = runningServers.remove().serverIdx;
                freeServers.add(serverIdx);
            }

            if(freeServers.isEmpty()) {
                currTime = runningServers.peek().endTime;
                while (!runningServers.isEmpty() && runningServers.peek().endTime <= currTime) {
                    int serverIdx = runningServers.remove().serverIdx;
                    freeServers.add(serverIdx);
                }

            }
            
            while(freeServers.size() > 0 && currTaskIdx < n &&  currTaskIdx <= currTime) {
                long endTime = currTime + tasks[currTaskIdx]; 
                int serverIdx = freeServers.remove();
                runningServers.add(new Pair(serverIdx,endTime));
                result[currTaskIdx++] = serverIdx;
            } 
                

            currTime++;
        }


        return result;
    }
}


class Pair {
    long endTime;
    int serverIdx;
    Pair(int serverIdx,long endTime) {
        this.endTime = endTime;
        this.serverIdx = serverIdx;
    }
}

