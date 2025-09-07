class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Node>> adj = constructGraph(n,edges,succProb);
        return dijkstraForMaxVal(start,end,adj,n); 
    }



    public List<List<Node>> constructGraph (int n, int[][] edges, double[] succProb) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0; i<n+1;i++) adj.add(new ArrayList<>());
        int idx = 0;
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];

            adj.get(u).add(new Node(v, succProb[idx])); 
            adj.get(v).add(new Node(u, succProb[idx]));
            
            idx++;
        }

        return adj;
    }


    public double dijkstraForMaxVal(int start, int end,List<List<Node>> adj,int n) {
        double[] maxProb = new double[n+1];
        Arrays.fill(maxProb,0);
       
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> {
            double dif = (double) b.wt - a.wt;
            return dif > 0.0 ? 1 : -1;
        });

        maxProb[start] = 1.0;
        pq.add(new Node(start,1.0));

        while(!pq.isEmpty()){
            Node curr = pq.remove();
            int u = curr.val;
            double currProb = curr.wt;

            if(currProb < maxProb[u]) continue;
            
            for(Node nbr : adj.get(u)) {
                int v = nbr.val;
                double amt = nbr.wt;
                double prod = (double) currProb * amt;

                if(prod > maxProb[v]){
                    maxProb[v] =prod;
                    pq.add(new Node(v,prod));
                   
                }
            }
        }


        return maxProb[end];
    }


}


class Node {
    double wt;
    int val;
    Node(int val, double wt) {
        this.wt = wt;
        this.val = val;
    }
}