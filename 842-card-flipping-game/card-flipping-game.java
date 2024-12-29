class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<fronts.length; i++){
            if(fronts[i]==backs[i]){
                hs.add(fronts[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<fronts.length; i++){
            if(!hs.contains(fronts[i])){
                ans = Math.min(ans, fronts[i]);
            }if(!hs.contains(backs[i])){
                ans = Math.min(ans, backs[i]);
            }
            
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}