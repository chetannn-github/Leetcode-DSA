// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         HashMap<Integer,Integer> freq = new HashMap<>();

//         for(char task : tasks){
//             int ch = (int) (task -'A');
//             freq.put(ch,freq.getOrDefault(ch,0)+1);
            
//         }
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
//             return freq.get(b) - freq.get(a);
//         });

//         for(int key : freq.keySet()){
//             pq.add(key);
//         }

//         int totalTimeTaken = 0;

//         while(!pq.isEmpty()){
//             int count = n +1;
//             List<Integer> completed = new ArrayList<>();

//             while(count != 0 && !pq.isEmpty()){
//                 int task = pq.remove();

//                 if(freq.get(task) != 1){
//                     completed.add(task);
//                     freq.put(task, freq.get(task)-1);
//                 }
//                 count--;
//                 totalTimeTaken++;
//             }
//             if(completed.size() == 0 && pq.size() == 0) return totalTimeTaken;

//             while(count != 0){
//                 totalTimeTaken++;
//                 count--;
//             }

//             for(int task : completed){
//                 pq.add(task);
//             }

//         }
        

//         return totalTimeTaken;



//     }
// }



class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char task : tasks){
            int ch = (int) (task -'A');
            freq[ch]++;
        }

        PriorityQueue<Integer> futureTasks = new PriorityQueue<>((a,b)->{
            return freq[b] - freq[a];
           //most freqent 
        });
        PriorityQueue<Pair> runningTasks = new PriorityQueue<>((a,b)->{
            return a.endTime - b.endTime;
        });

        for(int i=0;i<26; i++) {
            if(freq[i] > 0) futureTasks.add(i);
        }

        int currTime = 0;

        while(!futureTasks.isEmpty() || !runningTasks.isEmpty()) {

            while (!runningTasks.isEmpty() && runningTasks.peek().endTime <= currTime) {
                int task = runningTasks.remove().task;
                futureTasks.add(task);
            }

            if(futureTasks.isEmpty()) {
                currTime = runningTasks.peek().endTime;
                int task = runningTasks.remove().task;
                futureTasks.add(task);
            }

            int endTime = currTime + n+1; 
            int taskToBeExecuted = futureTasks.remove();

            if(freq[taskToBeExecuted] > 1) {
                runningTasks.add(new Pair(taskToBeExecuted, endTime));
                freq[taskToBeExecuted]--;
            }

            
            currTime++;
        }


        return currTime;
    }
}


class Pair {
    int endTime,task;
    Pair(int task,int endTime) {
        this.endTime = endTime;
        this.task = task;
    }
}

