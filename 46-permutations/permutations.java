class Solution {
    private List<List<Integer>> result;
    private Set<Integer> st;
    private int n;

    public void solve(List<Integer> temp, int[] nums) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!st.contains(nums[i])) {
                temp.add(nums[i]);
                st.add(nums[i]);

                solve(temp, nums);

                st.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        result = new ArrayList<>();
        st = new HashSet<>();
        
        List<Integer> temp = new ArrayList<>();

        solve(temp, nums);

        return result;
    }

}