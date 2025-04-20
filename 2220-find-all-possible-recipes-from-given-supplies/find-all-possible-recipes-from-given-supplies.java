class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> suppliesSet = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();
        int n = recipes.length;
        HashMap<String,Integer> map = new HashMap<>();

        for(String supply : supplies){
            suppliesSet.add(supply);
        }

        for(int i=0; i<n; i++){
            map.put(recipes[i],i);
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(String ingredient : ingredients.get(i)){
                if(!suppliesSet.contains(ingredient)){
                    int idx = map.getOrDefault(ingredient,-1);

                    if(idx !=-1){
                        adj.get(idx).add(i);  
                    }
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<String> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.remove();
            ans.add(recipes[curr]);

            for(int nbr : adj.get(curr)){
                if(--indegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
        }

        return ans;
    }
}