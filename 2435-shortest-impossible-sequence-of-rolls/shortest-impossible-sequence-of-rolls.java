class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int n = rolls.length;
        int window = 1;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int val : rolls) {
            map.put(val,map.getOrDefault(val,0)+1);
            if(map.size() == k) {
                map = new HashMap<>();
                window++;
            }
        }

        return window;

    }
}