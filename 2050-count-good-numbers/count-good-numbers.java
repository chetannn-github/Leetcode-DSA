class Solution {
    public long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long oddPos = n>>1;
        long evenPos = n - oddPos;
        // 4 prime digits  hain 
        //5 even digits hain

        // now question is kiii hume yhh btana hhh kiii n digits me se kuch digit select krniii h
        // aur koi bhi digit kitne baar bhiii select krr skte h aur unke permutations bhi krne h.

        // answer is 4^oddPos * 5^evenPos
        System.out.println(powerxn(4,oddPos) );
        long ans = (powerxn(4,oddPos)  * powerxn(5,evenPos) ) % MOD ;

        return (int) ans  ;

    }

    public long powerxn(long x , long n){
        if(n==0){
            return 1;
        }

        long temp = powerxn(x,n/2);

        if(n%2==0){
            return (temp*temp) %MOD;
        }else{
            return  (x*temp*temp) %MOD;
        }

    }
}