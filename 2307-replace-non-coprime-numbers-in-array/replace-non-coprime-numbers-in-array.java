class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();


        for(int i=0; i<n; i++) {
            int curr = nums[i];
            boolean isNonCoprime = true;

            while(!st.isEmpty() && isNonCoprime) {
                int prev = st.peek();
                int hcf = getHCF(prev,curr);
                isNonCoprime = hcf > 1;

                if(isNonCoprime) {
                    st.pop();
                    long prod = (long) prev * curr;
                    long lcm = prod / (long) hcf;

                    curr = (int) lcm;
                }
            }
        
            st.push(curr);
            
        }
        
        return stackToList(st);
    }

    private int getHCF(int a, int b) {
        return b == 0 ? a : getHCF(b,a%b);
    }

    private <T> List<T> stackToList(Stack<T> st) {
        List<T> list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        Collections.reverse(list);
        return list;
    }

}