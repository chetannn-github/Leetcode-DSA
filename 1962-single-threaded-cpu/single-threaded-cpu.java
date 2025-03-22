//tle
// class Solution {
//     public int[] getOrder(int[][] tasks) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
//             if(tasks[a][0] != tasks[b][0]){
//                 return tasks[a][0] - tasks[b][0];
//             }else if(tasks[a][1] != tasks[b][1]){
//                 return tasks[a][1] - tasks[b][1];
//             }
//             return a - b;
//         });
//         int idx = 0;
//         for(int[] task : tasks){
//             pq.add(idx);
//             idx++;
//         }

//         int[] ans = new int[tasks.length];

//         idx = 0;
//         int currTime = 0;

//         while(idx != tasks.length){
//             int currTaskIdx = pq.remove();
//             currTime = tasks[currTaskIdx][0];
//             int nextTime = currTime + tasks[currTaskIdx][1];

//             ans[idx++] = currTaskIdx;

//             while(!pq.isEmpty()){
//                 int nextTaskIdx = pq.peek();

//                 if(tasks[nextTaskIdx][0] < nextTime){
//                     pq.remove();
//                     tasks[nextTaskIdx][0] = nextTime;
//                     pq.add(nextTaskIdx);
//                 }else{
//                     break;
//                 }
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    public int[] getOrder(int[][] tasks) {
        // starting time ke hisab se sort krke rkhaa hh
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(tasks[a][0] != tasks[b][0]){
                return tasks[a][0] - tasks[b][0];
            }else if(tasks[a][1] != tasks[b][1]){
                return tasks[a][1] - tasks[b][1];
            }
            return a - b;
        });
        int idx = 0;
        for(int[] task : tasks){
            pq.add(idx);
            idx++;
        }

        int[] ans = new int[tasks.length];
        idx = 0;
        PriorityQueue<Integer> pendingTasks = new PriorityQueue<>((a,b)->{
            // duration ke hisaab se 
            if(tasks[a][1] != tasks[b][1]){
                return tasks[a][1] - tasks[b][1];
            }
            return a - b;
        });
        
        int nextTime = 0;
        int currTime = 0;

        while(idx != tasks.length){
            if(!pq.isEmpty() && pendingTasks.isEmpty()){
                pendingTasks.add(pq.remove());
                currTime = tasks[pendingTasks.peek()][0];
            }
            int currTaskIdx = pendingTasks.remove();
            nextTime = currTime + tasks[currTaskIdx][1];

            ans[idx++] = currTaskIdx;
            while(!pq.isEmpty() && nextTime >= tasks[pq.peek()][0]){
                pendingTasks.add(pq.remove());
            }

            currTime = nextTime;
        }

        return ans;
    }
}

