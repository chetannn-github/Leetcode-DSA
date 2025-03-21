class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));

        for(int row[] : matrix){
            for(int num : row){
                pq.add(num);
                if(pq.size()>k) pq.remove();
            }
        }
        return pq.peek();
    }
}