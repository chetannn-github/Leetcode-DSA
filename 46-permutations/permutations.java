class Solution {
    List<List<Integer>> result;
    Set<Integer> st;

    // public void solve(List<Integer> temp, int[] nums) {
    //     if (temp.size() == nums.length) {
    //         result.add(new ArrayList<>(temp));
    //         return;
    //     }

    //     for (int num : nums) {
    //         if (!st.contains(num)) {
    //             temp.add(num);
    //             st.add(num);

    //             solve(temp, nums);

    //             st.remove(num);
    //             temp.remove(temp.size() - 1);
    //         }
    //     }
    // }
    
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        st = new HashSet<>();

        List<Integer> temp = new ArrayList<>();
        solve(temp, nums);

        return result;
    }
    public void solve(List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if (!st.contains(i)) {
                temp.add(nums[i]);
                st.add(i);

                solve(temp, nums);
                temp.remove(temp.size()-1);
                st.remove(i);
            }
        }
    }
}