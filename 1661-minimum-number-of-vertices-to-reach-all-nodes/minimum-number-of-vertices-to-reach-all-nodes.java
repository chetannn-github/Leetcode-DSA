class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> hs = new HashSet<>();
        
        for(int i=0; i<n; i++) hs.add(i);
        for(List<Integer> edge : edges){
            hs.remove(edge.get(1));
        }
        List<Integer> ans = new ArrayList<>();
        for(int node : hs){
            ans.add(node);
        }
        return ans;
    }
}