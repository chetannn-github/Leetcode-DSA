class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefixProd = 1;
        int suffixProd = 1;
        int n = nums.length;

        int[] leftProd = new int[n];
        int[] rightProd = new int[n];

        for (int i =0; i<n;i++){
            leftProd[i] = prefixProd;
            prefixProd *= nums[i];
            
            rightProd[n-1-i] = suffixProd;
            suffixProd *= nums[n-1-i];
        }
        for (int i =0; i<n;i++){
            leftProd[i] *= rightProd[i];
        }
        return leftProd;
    }
}