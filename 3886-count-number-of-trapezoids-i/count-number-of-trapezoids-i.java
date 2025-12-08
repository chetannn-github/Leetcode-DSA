class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int MOD = 1_000_000_007;

        for(int[] point : points) {
            int x = point[0], y = point[1];
            map.put(y,map.getOrDefault(y,0)+1);
        }

        List<Long> levels = new ArrayList<>();
        
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(freq > 1) {
                long nc2 = ((long) freq * (freq-1) / 2) % MOD;
                levels.add(nc2);
            }
        }

        long cumSum = 0L;
        long result = 0L;
        for(int i=levels.size()-1; i>=0; i--) {
            long currRes = (cumSum * levels.get(i)) % MOD;
            result = (result + currRes) % MOD;
            cumSum = (cumSum + levels.get(i)) % MOD;
        }
        

        return (int) (result % MOD);
    }
}