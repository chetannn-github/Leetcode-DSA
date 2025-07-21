class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int num : nums) hm.put(num,hm.getOrDefault(num,0)+1);


        int ops = 0;

        for(int key : hm.keySet()) {
            int freq = hm.get(key);
            if(freq % 3 == 0) {
                ops += Math.ceil((double)freq/3);

            }else{
                int rem = freq % 3;
                int threeOps = freq/3;

                if(rem == 1) {
                    threeOps--;
                    rem += 3;
                }

                if(threeOps < 0) return -1;
                int twoOps = rem / 2;
                ops += threeOps + twoOps; 
            }
        }

        return ops;
    }
}