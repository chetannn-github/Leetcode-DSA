class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int minOne = 10;
        int minTwo = 10;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums1){
            minOne = Math.min(num,minOne);
            hs.add(num);
        }
        for(int num : nums2){
            minTwo = Math.min(num,minTwo);
            if(hs.contains(num)) min = Math.min(min,num);
        }

        
        if(minOne >= minTwo){
            return Math.min(10*minTwo + minOne,min);
        }

        return Math.min(minTwo + 10*minOne,min);

    }
}