class Solution {
    List<Node>[] graph;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        constructGraph(n, flights);
        return BFSWithKSteps(n,src,dst,k);
    }

    private void constructGraph(int n, int[][] flights) {
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] flight : flights){
            int u = flight[0], val = flight[1], price = flight[2];
            graph[u].add(new Node(val,price));
        }
    }


    private int BFSWithKSteps(int n, int src, int dst, int k) {
        Queue<Node> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(new Node(src,0));
        dist[src] = 0;
        int level = 0;

        while(!queue.isEmpty() && k >= level){
            int currSize = queue.size();

            while(currSize-->0){
                Node curr = queue.remove();
                int u = curr.val;
                int price = curr.price;

                // if(dist[u] < price) continue; we cant do this because broo mujhe stops bhi dekhne hain
                // mehgaa chalega mujhee but pahuchna hain

                for(Node nbr : graph[u]){
                    int v = nbr.val;
                    int amt = nbr.price;
                    if(amt + price < dist[v]){
                        dist[v] = amt + price;
                        queue.add(new Node(v,dist[v])); 
                    }  
                }
            }

            level++;

        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}


class Node {
    int val, price;
    Node(int val, int price) {
        this.val = val;
        this.price = price;
    }
}