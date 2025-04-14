class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<List<Double>>> adj = new ArrayList<>();

        for(int i=0; i<n+1;i++) adj.add(new ArrayList<>());
        int idx = 0;
        for(int[] edge : edges){
            List<Double> ls = new ArrayList<>();
            ls.add((double) edge[1]);
            ls.add(succProb[idx]);
            adj.get(edge[0]).add(ls); 
            
            ls = new ArrayList<>();
            ls.add((double)edge[0]);
            ls.add(succProb[idx]);
            adj.get(edge[1]).add(ls);
            
            idx++;
        }

        double[] dis = new double[n+1];
        Arrays.fill(dis,Double.MIN_VALUE);
       
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> {
            double dif = (double) a[0] - b[0];
            return dif > 0.0 ? 1 : -1;
        });
        pq.add(new double[]{(double) start,1.0});

        while(!pq.isEmpty()){
            double curr[] = pq.remove();
            double u = curr[0];
            double prob = curr[1];

            for(List<Double> nbr : adj.get((int)curr[0])){
                double v = nbr.get(0);
                double amt = nbr.get(1);
                double prod = (double) prob * amt;

                if(prod > dis[(int)v]){
                    dis[(int)v] =prod;
                    pq.add(new double[]{v,prod});
                   
                }
            }
        }

        return dis[end] == Double.MIN_VALUE ? 0.0000 : dis[end];
        
    }
}