class Solution {
    HashSet<Integer> visited;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distFromNode1 = new int[n];
        Arrays.fill(distFromNode1, -1);
        int[] distFromNode2 = new int[n];
        Arrays.fill(distFromNode2, -1);

        visited = new HashSet<>();
        dfs(edges,node1,0,distFromNode1);

        visited = new HashSet<>();
        dfs(edges,node2,0,distFromNode2);

        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ans[1] = -1;



        for(int i=0; i<n; i++){
            if(distFromNode1[i] != -1 && distFromNode2[i] != -1){
                int max = Math.max(distFromNode1[i],distFromNode2[i] );
                if(ans[0] > max){
                    ans[0] = max;
                    ans[1] = i;
                }
            }
        }

        return ans[1];
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