class Solution {
    int n;
    int x;
    public int maximumRemovals(String s, String p, int[] removable) {
        int start = 0;
        int end = removable.length;
        int ans = 0;
        n = s.length();
        x = p.length();

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if(checkPossible(s,p,removable,mid)) {
                ans = mid; 
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public boolean checkPossible (String s, String p , int[] removable, int k) {
        HashSet<Integer> indices = new HashSet<>();

        for(int i=0; i<k; i++) {
            indices.add(removable[i]);
        }

        int j=0;
        for(int i=0; i<n; i++) {
            if(indices.contains(i)) continue;
            if(s.charAt(i) == p.charAt(j)) j++;
            if(j == x) return true;
        }

        return false;
    }
}