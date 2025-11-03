class Solution {
    int MOD = 1_000_000_007;
    List<Long>[] pascal;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        preComputeFactorial(n);
        return solve(toList(nums)) - 1;
    }

    public int solve(List<Integer>nums) {
        int n = nums.size();
        if(n < 3) return 1;

        List<Integer> leftSubTree = new ArrayList<>();
        List<Integer> rightSubTree = new ArrayList<>();
        int root = nums.get(0);

        for(int num : nums) {
            if(num < root) leftSubTree.add(num);
            else if(num > root) rightSubTree.add(num);
        }
        long leftWays = solve(leftSubTree);
        long rightWays = solve(rightSubTree);
        long totalWays = (((leftWays * rightWays) % MOD) * pascal[n - 1].get(leftSubTree.size())) % MOD;

        return (int) (totalWays % MOD);
    }

    public static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int num : arr) list.add(num);
        return list;
    }

    

    private void preComputeFactorial(int n) {
        pascal = new List[n];
        for(int i=0; i<n; i++) {
            List<Long> row = new ArrayList<>();
            for(int j=0; j<i+1; j++) {
                if(j == 0 || j==i) row.add(1L);
                else row.add((pascal[i-1].get(j-1) + pascal[i-1].get(j)) % MOD );
            }
            pascal[i] = row;
        }
    }
}