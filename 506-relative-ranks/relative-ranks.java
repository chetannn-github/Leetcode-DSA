class Solution {
    public String[] findRelativeRanks(int[] scores) {
        int n = scores.length;
        String[] ans = new String[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (scores[b]-scores[a]));

        for(int i=0; i<n; i++){
            pq.add(i);
        }
        int rank = 1;
        while(!pq.isEmpty()){
            
            int maxIdx =pq.remove();

            if(rank==1){
                ans[maxIdx] = "Gold Medal";
            }else if(rank==2){
                ans[maxIdx] = "Silver Medal";
            }else if(rank==3){
                ans[maxIdx] = "Bronze Medal";
            }else{
                ans[maxIdx] = rank +"" ;
            }
            rank++;
        }
        
        return ans;
    }
}