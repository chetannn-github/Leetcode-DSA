class Solution {
    HashSet<Integer> visited;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distFromNode1 = new int[n];
        Arrays.fill(distFromNode1, Integer.MAX_VALUE);
        int[] distFromNode2 = new int[n];
        Arrays.fill(distFromNode2,Integer.MAX_VALUE);

        visited = new HashSet<>();
        dfs(edges,node1,0,distFromNode1);

        visited = new HashSet<>();
        dfs(edges,node2,0,distFromNode2);

        

        int resultDist = Integer.MAX_VALUE;
        int resultNode = -1;
        for(int i=0; i<n; i++){
            int currRes = Math.max(distFromNode1[i], distFromNode2[i]);
            if(currRes < resultDist) {
                resultDist = currRes;
                resultNode = i;
            }
            
        }

        return resultNode;
    }

    public void dfs(int[] edges, int curr, int dis, int[] distances){
        visited.add(curr);
        distances[curr] = dis;
        int nbr = edges[curr];

        if(!visited.contains(nbr) && nbr!= -1){
            dfs(edges,edges[curr], dis+1, distances);
        }
    }
}


