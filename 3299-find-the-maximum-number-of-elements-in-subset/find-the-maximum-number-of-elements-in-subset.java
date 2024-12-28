class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        int ans = 1;
        long temp = 1 ;

        for(int num : nums){
            int tempAns= 1;
            temp= num*num;

            if(num==1){
                int ones = hm.get(1);
                tempAns = ones%2==1 ? ones : ones-1;

            }else if(hm.get(num)>=2 && temp < Integer.MAX_VALUE && hm.containsKey((int)(temp))){
                tempAns++;
                
                while(temp < Integer.MAX_VALUE && hm.getOrDefault((int)(temp),0)>=2){
                    tempAns +=2;
                    temp =  temp*temp;
                }
                if(temp < Integer.MAX_VALUE &&hm.getOrDefault((int)(temp),0)==1){
                    tempAns++;
                }else{
                    tempAns--;
                }
                
            }
            temp = 1;
            ans = Math.max(ans,tempAns);
            if(ans==nums.length || ans== nums.length-1){
                return ans;
            }
        }
        return ans;
    }
}