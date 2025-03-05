class Solution {
    int n;
    public int countSubstrings(String s) {
        n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += solve(s,i,i);
        }
        return ans;
    }

    public int solve(String s, int start, int end){
        int count;
        if(end>=n){
            return 0;
        }
        
        count = isPalindrome(s,start,end);
        
        int take = solve(s,start,end+1);
        
        count += take;
        return count;
    }

    public int isPalindrome(String s, int left, int right) {
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
}