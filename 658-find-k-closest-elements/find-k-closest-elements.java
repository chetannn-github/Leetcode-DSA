class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int dis1 = Math.abs(x-a);
            int dis2 = Math.abs(x-b);
            if(dis1 == dis2){
                return b - a;
            }else{
                return dis2 - dis1;
            }
        });

        for(int point : arr){
            pq.add(point);
            if(pq.size() > k) pq.remove();
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.remove());
        }
        Collections.sort(result);

        return result;

    }
}