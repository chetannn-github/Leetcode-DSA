class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] isPresent = new int[1001];

        for(int num : arr) {
            isPresent[num] = 1;
        }
        int i=1;
        for(; i<1001; i++) {
            int num = isPresent[i];
            if(num == 0) {
                k--;
                if(k == 0) {
                    return i;
                }
            }
        }

        while(k-->0) { i++;
        }
        return i -1;


    }
}