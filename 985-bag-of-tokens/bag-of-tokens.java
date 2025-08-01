class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length-1;

        int maxScore = 0;
        int currPower = power;
        int currScore = 0;

        while(left <= right) {
            if(currPower >= tokens[left]) {
                currScore++;
                currPower -= tokens[left++];
            }else if(currScore > 0) {
                currScore--;
                currPower += tokens[right--];
            }else break;
            
            
        

            maxScore = Math.max(currScore,maxScore);
        }

        return maxScore;
    }
}