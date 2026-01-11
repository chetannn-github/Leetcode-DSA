// class Solution {
//     public int findPairs(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         int count = 0;

//         if(k == 0) {
//             for(int freq : map.values()) {
//                 if(freq > 1) count++;
//             }
//         }else{
//             for(int num : map.keySet()) {
//                 if(map.containsKey(num + k)) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }


// class Solution {
//     public int findPairs(int[] arr, int k) { 
//         int result = 0;
//          HashSet<Long> set = new HashSet<>();
//           for(int i=0; i<arr.length-1; i++){ 
//             for(int j= i+1; j<arr.length; j++){ 
//                 int min = Math.min(arr[i],arr[j]);
//                 int max = Math.max(arr[j],arr[i]);
//                 long hashCode = (((long) min) << 32) | (max & 0xffffffffL);

//                 if(set.contains(hashCode)) continue; 
//                 result += Math.abs(arr[i]-arr[j]) == k ? 1 : 0; 
//                 set.add(hashCode); 
//             } 
//         } 
//         return result;
//     } 
// }

class Solution {
    public int findPairs(int[] arr, int k) { 
        Arrays.sort(arr);
        int count = 0;

        for(int i=0; i<arr.length-1; i++) {
            if(i>0 && arr[i] == arr[i-1]) continue;

            int curr = arr[i];
            int next = arr[i] + k;
            count += isExists(arr,next,i+1) ? 1 : 0;
            
        }

        return count;
    } 

    private boolean isExists(int[] arr, int target, int start) {
        int end = arr.length-1;

        while(start <= end) {
            int mid = start + ((end-start)>>1);

            if(arr[mid] == target) return true;
            else if(arr[mid] > target) end = mid-1;
            else start = mid+1;
        }

        return false;
    }
}
