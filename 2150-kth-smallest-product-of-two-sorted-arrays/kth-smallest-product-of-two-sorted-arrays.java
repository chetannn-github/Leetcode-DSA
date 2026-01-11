class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long start = Math.min(
            Math.min((long)nums1[0]*nums2[0], (long)nums1[0]*nums2[nums2.length-1]),
            Math.min((long)nums1[nums1.length-1]*nums2[0], (long)nums1[nums1.length-1]*nums2[nums2.length-1])
        );

        long end = Math.max(
            Math.max((long)nums1[0]*nums2[0], (long)nums1[0]*nums2[nums2.length-1]),
            Math.max((long)nums1[nums1.length-1]*nums2[0], (long)nums1[nums1.length-1]*nums2[nums2.length-1])
        );
        long result = -1;

        while(start <= end) {
            long mid = start + ((end-start)>>1);
            long smallerProd = countSmallerOrEqual(nums1,nums2,mid);

            if(smallerProd >= k) {
                result = mid;
                end = mid-1;
            }else start = mid+1;
        }

        return result;
    }

    private long countSmallerOrEqual(int[] nums1, int[] nums2, long target) {
        long count = 0;
        int m = nums2.length;

        for(int num : nums1) {
            if(num >= 0) {
                int start = 0, end = m - 1, res = -1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if ((long) num * nums2[mid] <= target) {
                        res = mid;
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
                count += res + 1;
            }else {
                int start = 0, end = m - 1, res = m;
                while (start <= end){
                    int mid = (start + end) / 2;
                    if ((long) num * nums2[mid] <= target) {
                        res = mid;
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                count += m - res;
            }
        }
        return count;
    }

}
