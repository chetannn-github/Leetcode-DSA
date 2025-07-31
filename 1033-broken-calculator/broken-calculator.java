class Solution {
    public int brokenCalc(int start, int end) {
        return solve(start, end);
    }

    private int solve(int start, int end) {
        if (end <= start) return start - end;

        if (end % 2 == 0) {
            return 1 + solve(start, end / 2);
        } else {
            return 1 + solve(start, end + 1);
        }
    }
}
