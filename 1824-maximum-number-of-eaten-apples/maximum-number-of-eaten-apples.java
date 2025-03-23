class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int currDay = 1;
        int currIdx = 0;
        int n = days.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1] - b[1]; // on the basis of rotting day
        });
        int count = 0;
        while(!pq.isEmpty() || currIdx < n){

            if(currIdx < n && apples[currIdx] != 0){
                pq.add(new int[]{apples[currIdx],days[currIdx] + currDay });
            }
            //expired apples ko bahar nikal doo
            while(!pq.isEmpty() && pq.peek()[1] <= currDay){
                pq.remove();
            }

            if(!pq.isEmpty()){
                int[] currApples = pq.remove();
                int expiry = currApples[1];
                int currAppleCount = currApples[0];

                count++;
                if(currAppleCount != 1){
                    pq.add(new int[]{currAppleCount - 1, expiry});
                }
            }
            
            currDay++;
            currIdx++;
        
        }

        return count;
    }
}