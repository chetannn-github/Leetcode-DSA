class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<Integer> temp = new ArrayList<>();
        solve(k,target, temp,1); 
        return result;
    }

    public void solve(int k, int target, List<Integer> temp, int start){
        if(target==0 && temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;

        }else if(target<0 || temp.size()>k){
            return;
        }

        for(int i=start; i<10; i++){
        
            temp.add(i);
            solve(k,target-i,temp,i+1);

            temp.remove(temp.size()-1);
        }
        return;
    }
}