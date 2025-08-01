class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        HashSet<Integer> added = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(
            (reward1[b] - reward2[b]) -(reward1[a] - reward2[a]))
        );
        
        for(int i=0; i<n; i++) pq.add(i);
        int totalPoints = 0;

        while(k-->0) {
            int currPointIdx = pq.remove();
            totalPoints += reward1[currPointIdx];
            added.add(currPointIdx);
        }

        for(int i=0; i<n; i++) {
            if(!added.contains(i)) {
                totalPoints += reward2[i];
            }
        }

        return totalPoints;
    }
}