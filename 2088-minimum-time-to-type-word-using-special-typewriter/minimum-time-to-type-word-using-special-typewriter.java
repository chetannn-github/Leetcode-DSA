class Solution {
    public int minTimeToType(String word) {
        int n = word.length();
        int ops = 0;
        int currPos = 0 ;

        for(char ch : word.toCharArray()) {
            int opt1 = Math.abs(currPos - (ch -'a'));
            int opt2 = 26 - opt1 ;
            ops += Math.min(opt1, opt2);
            currPos = (ch -'a');
        }
        return n + ops;
    }
}