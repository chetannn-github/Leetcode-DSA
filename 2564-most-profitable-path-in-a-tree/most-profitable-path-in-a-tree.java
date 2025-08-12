class Solution {
    List<List<Integer>> adj;
    List<Integer> bobPath;
    int maxScore;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        adj = new ArrayList<>();
        bobPath = new ArrayList<>();
        maxScore = Integer.MIN_VALUE;
        int n = amount.length;
        
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        bobPath.add(bob);
        getPathToZero(bob, new HashSet<>());

        int[] bobStepNum = new int[n];
        Arrays.fill(bobStepNum,Integer.MAX_VALUE);

        for(int i=0; i<bobPath.size(); i++) {
            bobStepNum[bobPath.get(i)] = i;
        }

        dfs(0,amount[0],new HashSet<>(),0,bobStepNum,amount);
        
        return maxScore;
    }


    private boolean getPathToZero(int start, HashSet<Integer> visited) {
        if(start == 0) {
            return true;
        }

        visited.add(start);

        for(int nbr : adj.get(start)) {
            if(!visited.contains(nbr)) {
                bobPath.add(nbr);
                if(getPathToZero(nbr,visited)) return true;
                bobPath.remove(bobPath.size()-1);
            }
        }

        return false;
    }


    private void dfs(int start, int currScore, HashSet<Integer> visited, int currStep,int[] bobStepNum,int[] amount) {
        visited.add(start);
        boolean isCurrNodeIsLeafNode = true;

        for(int nbr : adj.get(start)) {
            if(!visited.contains(nbr)) {
                isCurrNodeIsLeafNode = false;

                int nextScore = currScore + amount[nbr];
                if(currStep + 1 == bobStepNum[nbr]) nextScore -= amount[nbr] /2;
                else if(currStep + 1 > bobStepNum[nbr]) nextScore -= amount[nbr];

                dfs(nbr, nextScore,visited,currStep+1, bobStepNum,amount);
            }
        }
        if(isCurrNodeIsLeafNode) maxScore = Math.max(currScore,maxScore);



    }





    
}