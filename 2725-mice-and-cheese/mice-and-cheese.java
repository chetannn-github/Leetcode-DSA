// class Solution {
//     public int miceAndCheese(int[] reward1, int[] reward2, int k) {
//         int n = reward1.length;
//         HashSet<Integer> added = new HashSet<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(
//             (reward1[b] - reward2[b]) -(reward1[a] - reward2[a]))
//         );
        
//         for(int i=0; i<n; i++) pq.add(i);
//         int totalPoints = 0;

//         while(k-->0) {
//             int currPointIdx = pq.remove();
//             totalPoints += reward1[currPointIdx];
//             added.add(currPointIdx);
//         }

//         for(int i=0; i<n; i++) {
//             if(!added.contains(i)) {
//                 totalPoints += reward2[i];
//             }
//         }

//         return totalPoints;
//     }
// }


class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int totalPoints = 0, n = reward1.length;
        int diff[] = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
            totalPoints += reward2[i];
        }
        
        Arrays.sort(diff);
        for (int i = 0; i < k; i++){
            totalPoints += diff[n - 1 - i];
        }
        return totalPoints;
    }
}