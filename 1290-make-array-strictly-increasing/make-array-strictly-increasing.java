class Solution {
    int[] arr1, arr2;
    int INVALID = 50000;
    HashMap<String,Integer> dp = new HashMap<>();
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        this.arr1 = arr1;
        this.arr2 = arr2;
        
        int result = solve(-1,0);
        return result >= INVALID ? -1 : result;
    }

    private int solve(int prevVal, int currIdx) {
        if(currIdx >= arr1.length) return 0;
        String key = prevVal + " " + currIdx;
        if(dp.containsKey(key)) return dp.get(key); 

        int result = INVALID;
        if(prevVal < arr1[currIdx]) {
            result = solve(arr1[currIdx], currIdx+1);
        }

        int idx = justBada(arr2,prevVal);
        if(idx != arr2.length) {
            result = Math.min(result, 1 + solve(arr2[idx],currIdx+1));
        }
        result = result >= INVALID ? INVALID : result;
        dp.put(key,result);
        return result;
        
    }

    private int justBada(int[] arr, int val) {
        int start = 0;
        int end = arr.length-1;
        int result = arr.length;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
        
            if(arr[mid] > val) {
                result = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }

        }
        return result;
    }


}