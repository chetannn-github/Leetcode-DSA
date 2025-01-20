class Solution {
    int result = 0;
    int n;
    public int beautifulSubsets(int[] nums, int k) {
        n = nums.length;
        // Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        solve(nums,k,temp,0);
        return result;

    }

    public void solve(int[] nums, int k, List<Integer> temp, int start){
        int size = temp.size();
        if(size>0){
            result++;
        }
        

        for(int i = start; i<n; i++){
            if(size ==0 || checkDifference(temp,k , nums[i])){
                temp.add(nums[i]);
                solve(nums,k,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean checkDifference(List<Integer> temp, int k, int check){
        for(Integer num : temp ){
            if(Math.abs(num - check)== k){
                return false;
            }
        }

        return true;
    }
}