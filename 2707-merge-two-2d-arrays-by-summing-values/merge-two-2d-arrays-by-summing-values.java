class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> ans = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        while (i<m || j<n){
            if(i>=m) ans.add(new int[]{nums2[j][0],nums2[j++][1]});
            else if( j>=n) ans.add(new int[]{nums1[i][0],nums1[i++][1]});
            else if(nums1[i][0]==nums2[j][0]) ans.add(new int[]{nums1[i][0],nums1[i++][1] + nums2[j++][1]});
            else if(nums1[i][0]>nums2[j][0]) ans.add(new int[]{nums2[j][0],nums2[j++][1]});
            else if(nums1[i][0]<nums2[j][0]) ans.add(new int[]{nums1[i][0],nums1[i++][1]});
        }
        int size = ans.size();
        int [][] arr = new int[size][2];
        for(int p=0; p<size; p++){
            arr[p] = ans.get(p);
        }
        return arr;
    }
}