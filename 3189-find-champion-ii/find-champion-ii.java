class Solution {
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer> indegree = new HashSet<>();
        for(int i=0; i<n;i++) indegree.add(i);
        
        for(int[] edge : edges){
            indegree.remove(edge[1]);
        }

        if(indegree.size() >1)  return -1;

        for(int ans : indegree) return ans;
        return -1;
    }
}