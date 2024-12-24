class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });

        int[] pre = new int[items.length+1];
        int max = items[0][1];

        for(int i=0; i<items.length; i++){
            max = Math.max(max,items[i][1]);
            pre[i+1] = max; 
        }

        for(int i=0; i<queries.length; i++){
            queries[i] = pre[findBound(items,queries[i])];
        }

        return queries;

    }

    public int findBound(int[][] nums , int q){
        int start = 0; 
        int end = nums.length-1;
        int bound = nums.length;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(nums[mid][0]>q){
                bound = mid;
                end = mid -1;
                
            }else{
                start = mid+1;
            }
        }

        return bound;
    }
}