class Solution {
    HashSet<Integer> hs;
    public boolean checkPowersOfThree(int n) {
        hs = new HashSet<>();
        return check(n);

    }

    public boolean check(int n){
        if(n==1 || n==0){
            return true;
        }else if(n<3){
            return false;
        }
        int bigPowerSub = 1;

        while(bigPowerSub <= n){
            bigPowerSub *=3;
        }
        bigPowerSub /=3;
        
        if(hs.contains(bigPowerSub)){
            return false;
        }else{
            hs.add(bigPowerSub);
        }

        return check(n-bigPowerSub); 
    }
}