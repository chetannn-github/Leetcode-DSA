class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int totalXOR2 = 0;
        for(int num : arr2) totalXOR2 ^= num;
        
        int XORSum = 0;
        for(int num : arr1) {
            XORSum ^= (num & totalXOR2);
        }

        return XORSum;
    }
}