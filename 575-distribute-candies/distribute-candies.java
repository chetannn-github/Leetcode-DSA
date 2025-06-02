class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int half = n/2;
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;

        for(int type : candyType) {
            if(!hs.contains(type)) {
                count++;
                hs.add(type);
            }

            if(count == half) return half;
        }
        return count;
    }
}