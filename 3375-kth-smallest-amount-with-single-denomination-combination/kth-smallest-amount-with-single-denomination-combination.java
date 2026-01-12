class Solution {
    public long findKthSmallest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        long start = arr[0], end = (long) arr[n-1] * (long) k;
        long result = 0;

        while(start <= end) {
            long mid = start + ((end-start)>>1);
            long smallerCount = findSmallerCount(arr,n,mid);

            if(smallerCount >= k) {
                result = mid;
                end = mid-1;
            }else start = mid+1;
        }

        return result;
    }

    private long findSmallerCount(int[] arr, int n, long target) {
        long count = 0;

        for(int mask=1; mask < (1<<n); mask++) {
            long lcm = 1;
            for(int i=0; i<n; i++) {
                if((mask & (1<<i)) > 0) {
                    lcm = getLCM(lcm,arr[i]);
                }
            }

            boolean isOddSetBits = (getBitCount(mask) & 1) == 1;
            count += (isOddSetBits ? 1L : -1L) * (long) (target / lcm);
        }
    
        return count;
    }

    private int getBitCount(int num) {
        int setBits = 0;
        while(num > 0) {
            setBits += ((num&1) > 0) ? 1 : 0;
            num >>= 1;
        }
        return setBits;
    }

    private long getLCM(long a,long b) {
        long prod = a*b;
        long hcf = getHCF(a,b);

        return prod / hcf;
    }


    private long getHCF(long a, long b) {
        if(b==0) return a;

        return getHCF(b,a%b);
    }
}

