class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> notAllowed = new HashSet<>();
        for(int num : banned) notAllowed.add(num);
        int sum = 0, count = 0;

        for(int i=1; i<=n; i++) {
            if(notAllowed.contains(i)) continue;
            if(sum + i > maxSum) continue;

            sum += i;
            count++;
        }

        return count;
    }
}