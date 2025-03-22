class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(char task : tasks){
            int ch = (int) (task -'A');
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return freq.get(b) - freq.get(a);
        });

        for(int key : freq.keySet()){
            pq.add(key);
        }

        int time = 0;

        while(!pq.isEmpty()){
            int count = n +1;
            List<Integer> completed = new ArrayList<>();

            while(count != 0 && !pq.isEmpty()){
                int task = pq.remove();

                if(freq.get(task) != 1){
                    completed.add(task);
                    freq.put(task, freq.get(task)-1);
                }
                count--;
                time++;
            }
            if(completed.size() == 0 && pq.size() == 0) return time;

            while(count != 0){
                time++;
                count--;
            }

            for(int task : completed){
                pq.add(task);
            }

        }
        

        return time;



    }
}