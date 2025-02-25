class Solution {
    public int[] findArray(int[] pref) {
        int prev = pref[0];
        int n =  pref.length;

        int ans[] = new int[n];
        ans[0] = pref[0];

        for(int i = 1; i<n; i++){
            ans[i] = prev ^ pref[i];
            prev = prev ^ ans[i];
        }
        return ans;
    }
}