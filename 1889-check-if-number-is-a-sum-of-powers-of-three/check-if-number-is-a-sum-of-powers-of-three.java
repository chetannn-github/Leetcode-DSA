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
        int bigPower = 1;

        while(bigPower <= n){
            bigPower *=3;
        }
        bigPower /=3;
        
        if(hs.contains(bigPower)){
            return false;
        }else{
            hs.add(bigPower);
        }

        return check(n-bigPower); 
    }
}