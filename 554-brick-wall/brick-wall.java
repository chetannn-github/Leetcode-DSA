class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0; 

        for(int i=0; i<wall.size(); i++){
            List<Integer> line = wall.get(i);
            int pre = 0; 
            for(int j=0; j<line.size()-1; j++){
                pre += line.get(j);
                hm.put(pre, hm.getOrDefault(pre,0)+1);
                max = Math.max(hm.get(pre),max);
            }
        }

        return wall.size() - max;
    }
}