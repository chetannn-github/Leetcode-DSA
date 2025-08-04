class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer,List<Integer>> grps = new HashMap<>();


        for(int i=0; i<groupSizes.length; i++ ) {
            int grpSize = groupSizes[i];
            List<Integer> grp = grps.getOrDefault(grpSize,new ArrayList<>());
            grp.add(i);

            if(grp.size() == grpSize) {
                result.add(grp);
                grp = new ArrayList<>();
            }

            grps.put(grpSize,grp);
        }


        return result;
    }
}