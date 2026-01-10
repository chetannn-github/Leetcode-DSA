class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;

        int m = nums1.length;
        int n = nums2.length;

        int currCount = 0;
        boolean isOddLength = ((m+n) & 1) == 1;
        int medianIdx = ((m+n) >> 1);

        int firstOne = -1;
        int secondOne = -1;
        
        while(secondOne == -1) {
            while((right >= n || (left < m && nums1[left] <= nums2[right])) ) {

                if(currCount == medianIdx) {
                    if(isOddLength) return nums1[left];
                    else secondOne = nums1[left];
                    break;
                }else if(currCount == medianIdx-1) {
                    firstOne = nums1[left];
                }
                left++;
                currCount++;
            }

            while(secondOne == -1 && (left >= m || (right < n && nums1[left] > nums2[right]))) {
                if(currCount == medianIdx) {
                    if(isOddLength) return nums2[right];
                    else secondOne = nums2[right];
                }else if(currCount == medianIdx-1) {
                    firstOne = nums2[right];
                }
                right++;
                currCount++;
            }
        }


        return (double) (firstOne + secondOne) / 2 ;
        
    }
}