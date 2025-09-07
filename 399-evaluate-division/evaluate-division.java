class Pair {
    String to;
    Double wt;

    Pair(String to, double wt) {
        this.to = to;
        this.wt = wt;
    }
}
class Solution {
    HashMap<String,List<Pair>> adj;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adj = new HashMap<>();
        constructGraph(equations,values);

        double[] result = new double[queries.size()];
        int idx = 0;
        for(List<String> q : queries){
            String u = q.get(0);
            String v = q.get(1);
            
            if(!adj.containsKey(u) || !adj.containsKey(v) ){
                result[idx++] = -1.0;
                continue;
            }
            
            result[idx++] = dfs(u,v,1.0, new HashSet<>());

        }
        return result;
    }

    public double dfs(String u, String v, double curr, HashSet<String> visited){
        if(u.equals(v)) return curr;
        visited.add(u);
        double result = -1.0;

        for(Pair nb : adj.get(u)){
            String nbr = nb.to;
            
            if(!visited.contains(nbr)){
                visited.add(nbr);
                double possibleAns = dfs(nbr,v,(double) curr * nb.wt,visited) ;
                if(possibleAns != -1.0){
                    return possibleAns;
                };
            }
        }   
        return result;
    }

    public void constructGraph(List<List<String>> equations, double[] values) {
        int idx = 0;
        for(List<String> eq : equations){
            String u = eq.get(0);
            String v = eq.get(1);

            List<Pair> ls = adj.getOrDefault(u,new ArrayList<>());
            ls.add(new Pair(v,values[idx]));
            adj.put(u,ls);

            ls = adj.getOrDefault(v,new ArrayList<>());
            ls.add(new Pair(u,(double) 1/values[idx++]));
            adj.put(v,ls);
        }
    }
}