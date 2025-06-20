class Solution {
    
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 0, right = 2_000_000_000, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (count(mid, a, b, c) >= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    int count(long num, long a, long b, long c) {
        long mulA = num/a ;
        long mulB = num/b ;
        long mulC = num/c ;

        long mulAB = (num / lcm(a,b));
        long mulAC = (num / lcm(a,c));
        long mulCB = (num / lcm(c,b));

        long mulABC = (num / lcm(a, lcm(b, c)));

        long count =(mulA + mulB + mulC - mulAB - mulAC - mulCB  + mulABC);
        return (int) count;
    }

    long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b%a, a);
    }
    long lcm(long a, long b) {
        // lcm * hcf = a * b;
        return a / gcd(a, b) * b ;
    }
}