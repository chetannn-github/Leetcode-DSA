// tle
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

// class Solution {
//     public int[] getOrder(int[][] tasks) {
//         // starting time ke hisab se sort krke rkhaa hh
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
//         PriorityQueue<Integer> pendingTasks = new PriorityQueue<>((a,b)->{
//             // duration ke hisaab se 
//             if(tasks[a][1] != tasks[b][1]){
//                 return tasks[a][1] - tasks[b][1];
//             }
//             return a - b;
//         });
        
//         int nextTime = 0;
//         int currTime = 0;

//         while(idx != tasks.length){
            
//             if(pendingTasks.isEmpty()){
//                 pendingTasks.add(pq.remove());
//                 currTime = tasks[pendingTasks.peek()][0];
//             }
//             int currTaskIdx = pendingTasks.remove();
//             nextTime = currTime + tasks[currTaskIdx][1];

//             ans[idx++] = currTaskIdx;
//             while(!pq.isEmpty() && nextTime >= tasks[pq.peek()][0]){
//                 pendingTasks.add(pq.remove());
//             }

//             currTime = nextTime;
//         }

//         return ans;
//     }
// }



class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // [start, duration, index] 
        int[][] taskList = new int[n][3];
        for (int i = 0; i < n; i++) {
            taskList[i][0] = tasks[i][0];
            taskList[i][1] = tasks[i][1];
            taskList[i][2] = i;
        }

        Arrays.sort(taskList, (a, b) -> (a[0] - b[0]));

       
        PriorityQueue<int[]> pending = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; // duration
            return a[2] - b[2]; // index
        });

        int time = 0, i = 0, idx = 0;
        int[] ans = new int[n];

        while (idx < n) {
          
            while (i < n && taskList[i][0] <= time) {
                pending.add(taskList[i++]);
            }

            if (!pending.isEmpty()) {
                int[] task = pending.remove();
                time += task[1];
                ans[idx++] = task[2];
            }else {
                time = taskList[i][0];
            }
        }

        return ans;
    }
}

