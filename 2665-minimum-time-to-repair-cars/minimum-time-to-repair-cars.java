class Solution {
    public long repairCars(int[] ranks, int cars) {
        int max = ranks[0];
       
        
        for(int i=1; i<ranks.length; i++){
            max = Math.max(ranks[i], max);
        }

        long start = 1;
        long end  =(long) cars * cars * max;
        long ans = 0;
        

        while(start<=end){
            long mid = start + ((end-start)>>1);
            
            if(checkPossible(ranks, cars, mid)){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }
        return (ans);
    }

    public boolean checkPossible(int[] ranks, int cars , long time){
        long count = 0;
        for(int i=0; i<ranks.length; i++){
            count += (long) Math.sqrt(time/ranks[i]);
            if (count >= cars) return true; 
        }

        return false;
    }
}