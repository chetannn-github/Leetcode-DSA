class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int one = -1;
        int two = -1;
        int countOne = 0, countTwo = 0;
    

        for (int num : nums) {
            if(num == one){
                countOne++;
            }else if(num == two){
                countTwo++;
            }else if(countOne == 0){
                one = num;
                countOne++;
            }else if(countTwo == 0){
                two = num;
                countTwo++;
            }else {
                countOne--;
                countTwo--;
            }
        }
        countOne = 0; countTwo = 0;
        for (int num : nums) {
            if (num == one) {
                countOne++;
            } else if (num == two) {
                countTwo++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        
        if(countOne>nums.length/3){
            ans.add(one);
        }

        if(countTwo> nums.length/3){
            ans.add(two);
        }
        return ans;
    }
}