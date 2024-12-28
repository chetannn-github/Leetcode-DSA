class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            if(hm.getOrDefault(num,0)==1 && hm.getOrDefault(num-1,0)==0 && hm.getOrDefault(num+1,0)==0){
                ans.add(num);
            }
        }

        return ans;
    }
}