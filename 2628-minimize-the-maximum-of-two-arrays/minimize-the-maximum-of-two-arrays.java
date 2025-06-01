class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long start = 1, end = (long) 1e18;
        long lcm = lcm(divisor1, divisor2);
        long ans = -1;

        while (start <= end) {
            long mid = start +( (end - start) >> 1);
            long notDiv1 = mid - mid / divisor1;
            long notDiv2 = mid - mid / divisor2;
            long notBoth = mid - (mid / divisor1 + mid / divisor2 - mid / lcm);
            long uncomman = notDiv1 + notDiv2 - (notBoth);

            if (notDiv1 >= uniqueCnt1 && notDiv2 >= uniqueCnt2 && uncomman >= uniqueCnt1 + uniqueCnt2) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        
        return (int) ans;
    }

    private long lcm(long a, long b) {
        return  (long)(( a  / gcd(a, b)) * b);
    }

    private long gcd(long a, long b) {
        return  (b == 0) ? a : gcd(b,a%b); 
    }

}
