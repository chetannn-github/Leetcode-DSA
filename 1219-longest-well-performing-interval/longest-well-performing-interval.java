class Solution {
    public int longestWPI(int[] hours) {
        int prefix = 0;
        int longestWPI = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<hours.length; i++) {
            prefix += hours[i] > 8 ? 1 : -1;

            if(prefix > 0) {
                longestWPI = i+1;
            }else {

                map.putIfAbsent(prefix, i);

                if(map.containsKey(prefix - 1)) {
                    longestWPI = Math.max(longestWPI, i - map.get(prefix - 1));
                }
            }
         }


        return longestWPI;
    }
}