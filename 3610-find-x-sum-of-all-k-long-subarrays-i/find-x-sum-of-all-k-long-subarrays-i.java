class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] freq = new int[51];
        int sum[] = new int[n-k+1];

        for(int i=0; i<k-1; i++){
            freq[nums[i]]++;
        }

        int start = 0;

        for(int end = k-1; end<n; end++){
            int kitneChaiye = x;
            freq[nums[end]]++;

            int tempSum = 0;

            for(int currFreq=k; currFreq>0 && kitneChaiye>0; currFreq--){
                for(int i = 50; i>=0 && kitneChaiye>0; i--){
                    if(freq[i] == currFreq){
                        tempSum += i * freq[i];
                        kitneChaiye--;
                    }

                }
            }

            freq[nums[start]]--;
            sum[start] = tempSum;
            start++;
            
        }

        return sum;

    }
}