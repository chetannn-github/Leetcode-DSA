// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int left = 0;
//         int right = 0;

//         int m = nums1.length;
//         int n = nums2.length;

//         int currCount = 0;
//         boolean isTotalOddLength = ((m+n) & 1) == 1;
//         int medianIdx = ((m+n) >> 1);

//         int firstOne = -1;
//         int secondOne = -1;
        
//         while(secondOne == -1) {
//             while((right >= n || (left < m && nums1[left] <= nums2[right])) ) {

//                 if(currCount == medianIdx) {
//                     if(isTotalOddLength) return nums1[left];
//                     else secondOne = nums1[left];
//                     break;
//                 }else if(currCount == medianIdx-1) {
//                     firstOne = nums1[left];
//                 }
//                 left++;
//                 currCount++;
//             }

//             while(secondOne == -1 && (left >= m || (right < n && nums1[left] > nums2[right]))) {
//                 if(currCount == medianIdx) {
//                     if(isTotalOddLength) return nums2[right];
//                     else secondOne = nums2[right];
//                 }else if(currCount == medianIdx-1) {
//                     firstOne = nums2[right];
//                 }
//                 right++;
//                 currCount++;
//             }
//         }


//         return (double) (firstOne + secondOne) / 2 ;
        
//     }
// }

class Solution { 
    final static int min = Integer.MIN_VALUE;
    final static int max = Integer.MAX_VALUE;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);

        boolean isTotalOddLength = ((m+n) & 1) == 1;
        int start = 0, end = m;
       
        int totalLeft = (m+n+1) >> 1;

        while(start <= end) {
            int mid = start + ((end-start)>>1);

            int l1 = mid == 0 ? min : nums1[mid-1];
            int l2 = totalLeft - mid == 0 ? min : nums2[totalLeft - mid-1];

            int r1 = mid == m ? max : nums1[mid];
            int r2 = totalLeft - mid >= n ? max : nums2[totalLeft - mid];

            boolean isGoodParition = (l1 <= r2 && l2 <= r1);

            if(isGoodParition) {
                if (isTotalOddLength) return Math.max(l1,l2);
                else return (double) (Math.max(l1,l2) + Math.min(r1,r2)) / 2;
                
            }else if(l1 > r2) end = mid-1;
            else start = mid+1;
        }

        return -1.0;
    }
}