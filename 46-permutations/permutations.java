class Solution {
    private List<List<Integer>> result;
    private Set<Integer> st;

    public void solve(List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int num : nums) {
            if (!st.contains(num)) {
                temp.add(num);
                st.add(num);

                solve(temp, nums);

                st.remove(num);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        st = new HashSet<>();

        List<Integer> temp = new ArrayList<>();
        solve(temp, nums);

        return result;
    }

}