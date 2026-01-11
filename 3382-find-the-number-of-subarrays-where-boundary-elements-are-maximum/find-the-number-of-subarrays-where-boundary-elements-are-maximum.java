// class Solution {
//     public long numberOfSubarrays(int[] nums) {
//         long result = 0;
//         int n = nums.length;
//         Stack<Integer> st = new Stack<>();

//         for(int i=0; i<n; i++) {
//             while(!st.isEmpty() && st.peek() < nums[i]) {
//                 st.pop();
//             }
//             st.push(nums[i]);
//             int count = 0;
//             while(!st.isEmpty() && st.peek() == nums[i]) {
//                 result++;
//                 st.pop();
//                 count++;
//             }

//             while(count-->0) st.push(nums[i]);
//         }

//         return result;
//     }
// }


class Solution {
    public long numberOfSubarrays(int[] nums) {
        long result = 0;
        int n = nums.length;
        Stack<Pair> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && st.peek().val < nums[i]) {
                st.peek().freq--;
                if(st.peek().freq == 0) st.pop();
            }

            if(!st.isEmpty() && st.peek().val == nums[i]) st.peek().freq++;
            else st.push(new Pair(nums[i],1));

            result += st.peek().freq;
        }

        return result;
    }
}


class Pair {
    int val, freq;
    Pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}