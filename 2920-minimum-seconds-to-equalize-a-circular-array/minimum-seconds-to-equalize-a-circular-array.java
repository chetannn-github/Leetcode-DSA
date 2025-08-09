// tle
// class Solution {
//     public int minimumSeconds(List<Integer> nums) {
//         int n = nums.size();
//         int minSecs = Integer.MAX_VALUE;

//         for(int num : nums) {
//             minSecs = Math.min(minSecs, bfs(num,nums, n));
//         }

//         return minSecs;
        
//     }


//     public int bfs(int target, List<Integer> nums, int n) {
//         Queue<Integer> queue = new LinkedList<>();
//         HashSet<Integer> visited = new HashSet<>();

//         for(int i=0; i<n; i++) {
//             if(nums.get(i) == target) {
//                 queue.add(i);
//                 visited.add(i);
//             }
//         }

//         int time = 0;
//         while(!queue.isEmpty() && visited.size() != n) {
//             int currSize = queue.size();

//             while(currSize--> 0) {
//                 int curr = queue.remove();

//                 int nbr1 = (curr + 1) % n;
//                 int nbr2 = (curr - 1 + n) % n;

                
//                 if(!visited.contains(nbr1)) queue.add(nbr1);
//                 visited.add(nbr1);
        
                
//                 if(!visited.contains(nbr2)) queue.add(nbr2);  
//                 visited.add(nbr2);          
//             }

//             time++;
//         }

//         return time;
        



        
//     }
// }

// jo maxfreq hain wo bhii logic fraud hainnn dosttt!!!
// wrong logiccccc!!!!!!
// class Solution {
//     public int minimumSeconds(List<Integer> nums) {
//         int n = nums.size();
//         int maxFreq = 1;
//         int maxFreqNum = nums.get(0);
       
//         HashMap<Integer,Integer> hm = new HashMap<>();

//         for(int num : nums) {
//             hm.put(num, hm.getOrDefault(num,0) + 1);

//             if(hm.get(num) >= hm.get(maxFreqNum)) {
//                 maxFreq = hm.get(num);
//                 maxFreqNum = num;
//             }
//         }

//         List<Integer> possibleResults = new ArrayList<>();
        
//         for(int key : hm.keySet()) {
//             if(hm.get(key) == maxFreq) {
//                 possibleResults.add(key);
//             }
//         }

        
//         int minSecs = Integer.MAX_VALUE;
//         for(int num : nums) {
//             minSecs = Math.min(minSecs, minSecondsNeeded(num,nums, n));
//         }

//         return minSecs;
        
//     }


//     public int minSecondsNeeded(int target, List<Integer> nums, int n) {
//         Queue<Integer> queue = new LinkedList<>();
//         HashSet<Integer> visited = new HashSet<>();

//         for(int i=0; i<n; i++) {
//             if(nums.get(i) == target) {
//                 queue.add(i);
//                 visited.add(i);
//             }
//         }

//         int time = 0;
//         while(!queue.isEmpty() && visited.size() != n) {
//             int currSize = queue.size();

//             while(currSize--> 0) {
//                 int curr = queue.remove();

//                 int nbr1 = (curr + 1) % n;
//                 int nbr2 = (curr - 1 + n) % n;

                
//                 if(!visited.contains(nbr1)) queue.add(nbr1);
//                 visited.add(nbr1);
        
                
//                 if(!visited.contains(nbr2)) queue.add(nbr2);  
//                 visited.add(nbr2);          
//             }

//             time++;
//         }

//         return time;
        



        
//     }
// }


class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, List<Integer>> positions = new HashMap<>();

        for (int i = 0; i < n; i++){
            int num = nums.get(i);
            List<Integer> pos = positions.getOrDefault(num, new ArrayList<>());
            pos.add(i);
            positions.put(num, pos);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> pos : positions.values()) {
            int maxGap = 0;

            for (int i = 1; i < pos.size(); i++) {
                maxGap = Math.max(maxGap, pos.get(i) - pos.get(i - 1) - 1);
            }

            maxGap = Math.max(maxGap, pos.get(0) + n - pos.get(pos.size() - 1) - 1);

            ans = Math.min(ans, (maxGap + 1) / 2);
        }

        return ans;
    }
}
