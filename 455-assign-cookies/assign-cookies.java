class Solution {
    public int findContentChildren(int[] players, int[] trainers) {
        int n = players.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int result = 0;

        for(int i=0, j = 0; i<n && j<trainers.length;) {
            if(players[i] <= trainers[j]) {
                i++;
                j++;
                result++;
            }else j++;
        }

        return result;
    }
}