class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // main kaam hain kiske equal krnaa hh wo find krnaa 
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = tops.length;

        for(int i=0; i<n; i++) {
            int top = tops[i];
            int bottom = bottoms[i];

            if(hm.getOrDefault(top,0) == i) {
                hm.put(top, i+1);
            }else {
                if(hm.containsKey(top)) hm.remove(top);
            }

            if(hm.getOrDefault(bottom,0) == i) {
                hm.put(bottom, i+1);
            }else {
                if(top != bottom && hm.containsKey(bottom)) hm.remove(bottom);
            }
        }



        int equalVal = -1;

        for(int key : hm.keySet()) {
            if(hm.get(key) == n ) equalVal = key;
        }

        if(equalVal == -1) return -1;
    
        int topFreq = 0; int bottomFreq = 0; 
        for(int i=0; i<n; i++) {
            topFreq += tops[i] == equalVal ? 1 : 0;
            bottomFreq += bottoms[i] == equalVal ? 1 : 0;
        }

        return Math.min(n-topFreq, n - bottomFreq);
    }
}