class Solution {
    List<List<Integer>> solutions = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();

        solve(n, k,1, temp);

        return solutions;
    }

    public void solve(int n, int k ,int start, List<Integer> temp){
        if(temp.size() == k){
            solutions.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start; i<=n; i++){

            temp.add(i);
            solve(n,k,i+1,temp);
            temp.remove(temp.size()-1);

        }
    }
}