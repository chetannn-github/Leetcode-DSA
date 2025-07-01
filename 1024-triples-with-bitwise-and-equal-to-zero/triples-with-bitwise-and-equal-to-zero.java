// class Solution {
//     public int countTriplets(int[] nums) {
//         int count = 0;
//         int n = nums.length;
//         for(int i=0; i<n; i++) {
//             for(int j=0; j<n; j++) {
//                 for(int k = 0; k<n; k++) {
//                     if(((nums[i] & nums[j]) & nums[k]) == 0) count++;
//                 }
//             }
//         }

//         return count;
//     }
// }


class Solution {
    public int countTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;

        for (int a : nums) {
            for (int b : nums) {
                int and = a & b;
                map.put(and, map.getOrDefault(and, 0) + 1);
            }
        }

        
        for (int c : nums) {
            for (int key : map.keySet()) {
                if ((key & c) == 0) {
                    count += map.get(key);
                }
            }
        }

        return count;
    }
}
