class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        Set<Integer> prev = new HashSet<>();
        HashSet<Integer> distinctVal = new HashSet<>();
        
        for(int num : nums) {
            Set<Integer> curr = new HashSet<>();

            for(Integer key : prev) {
                int newOR = key | num;
                distinctVal.add(newOR);
                curr.add(newOR);
            }
            curr.add(num);
            distinctVal.add(num);
            prev = curr;
        }

        return distinctVal.size();
    }
}
