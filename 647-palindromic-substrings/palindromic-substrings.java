class Solution {
    int n;
    HashMap<String,Integer> dp;
    public int countSubstrings(String s) {
        n = s.length();
        dp = new HashMap<>();

        StringBuilder sb = new StringBuilder();  
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += solve(s,sb,i);
        }
        return ans;
    }

    public int solve(String s,StringBuilder sb, int start){
        int size = sb.length(); 
        String key = sb.toString();
        
        int max;
        if(dp.containsKey(key)){
            max = dp.get(key);
        }else{
            max = isPalindrome(key,size);
        }
        if(start>=n){
            return max;
        }
       
        
        sb.append(s.charAt(start));
        int take = solve(s,sb,start+1);
        sb.setLength(size);

        max += take;
        return max;
    }

    public int isPalindrome(String s, int size) {
        int left = 0;
        int right = size-1;
        if(size==0){
            dp.put(s,0);
            return 0;
        }
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                dp.put(s,0);
                return 0;
            }
            left++;
            right--;
        }
        dp.put(s,1);
        return 1;
    }
}