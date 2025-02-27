class Solution {
    int info[][];
    int rows ;
    HashMap<String,Integer> dp ;
    public int findMaxForm(String[] strs, int m, int n) {
        rows = strs.length;
        info =  new int[rows][2];
        dp = new HashMap<>();

        for(int i=0; i<rows; i++){
            int length = strs[i].length();
            int zeroes = countZeroes(strs[i],length);
            info[i][0] = zeroes;
            info[i][1] = length - zeroes; 
        }

        return solve(0,m,n);
    }

    public int solve(int start, int m , int n){
        if(start>=rows){
            return 0;
        }

        String key = "start -> " + start + "m -> " + m + "n -> " + n;
        if(dp.containsKey(key)){
            return dp.get(key);
        }


        int skip = solve(start+1, m , n);
        int take = 0;
        if(m-info[start][0]>=0 && n - info[start][1]>=0){
            take = 1+ solve(start+1,m-info[start][0], n - info[start][1]);
        }
        
        dp.put(key,Math.max(take,skip));
        return dp.get(key);
    }




















    public int countZeroes(String s, int n){
        int zeroes = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '0') zeroes++;
        }
        return zeroes;
    }
}