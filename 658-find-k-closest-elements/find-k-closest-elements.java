class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int dis1 = Math.abs(x-a);
            int dis2 = Math.abs(x-b);
            if(dis1 == dis2){
                return a - b;
            }else{
                return dis1 - dis2;
            }
        });

        for(int point : arr){
            pq.add(point);
        }
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        while(idx != k){
            ans.add(pq.remove());
            idx++;
        }
        Collections.sort(ans);

        return ans;

    }
}