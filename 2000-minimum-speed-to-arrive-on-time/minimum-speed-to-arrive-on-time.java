class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int start = 1; 
        int end = 10000000;
        
        int ans = -1;
        while(start<=end){
            int mid = start + ((end - start)>>1);
            if(isPossible(dist,mid,hour)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans; 
    }

    public boolean isPossible(int[] dist , int hr , double hour){
        double time = 0; 
        for(int i=0; i<dist.length-1; i++){
            if((dist[i]%hr)==0){
                time += dist[i]/hr;
            }else{
                 time +=( dist[i]/hr) +1;
            }
        }
        time +=  ((double)dist[dist.length-1]/hr);
    
        return time <= hour;
    }
}