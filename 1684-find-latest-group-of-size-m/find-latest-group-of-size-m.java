// tle
// class Solution {
//     public int findLatestStep(int[] nums, int m) {
//         int n = nums.length;
//         boolean[] visited = new boolean[n];
//         DSU dsu = new DSU(n);
//         int lastStep = -1;


//         for(int i=0; i<n; i++) nums[i]--;
        
//         for(int i=0; i<n; i++) {
//             int num = nums[i];
//             int prev = num - 1 ;
//             int next = num + 1;

//             if(prev >= 0 && visited[prev]) dsu.union(num, prev);
//             if(next < n && visited[next]) dsu.union(num,next);
//             visited[num] = true;

//             HashMap<Integer,Integer> parentsFreq = new HashMap();
            
//             for(int j=0; j<n; j++) {
//                 if(visited[j]) {
//                     int parent = dsu.find(j);
//                     int prevFreq = parentsFreq.getOrDefault(parent,0);
//                     parentsFreq.put(parent, prevFreq + 1);
//                 }
//             }


//             for(int key : parentsFreq.keySet()) {
//                 if(parentsFreq.get(key) == m) {
//                     lastStep = i+1;
//                 } 
//             }
            
//         }
//         return lastStep;
//     }

    
// }


class DSU {
    int[] parent, rank;
    HashMap<Integer,Integer> membersSize;
    HashMap<Integer,Integer> parentToGroupSize;
    HashMap<Integer,Integer> groupSize;

    DSU(int size) {
        parent = new int[size];
        rank = new int[size];
        membersSize = new HashMap<>();
        parentToGroupSize = new HashMap<>();
        groupSize = new HashMap<>();

        for(int i=0; i<size; i++) {
            parent[i] = i;
        } 
    }


    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) return;

        int xGroupSize = parentToGroupSize.get(xParent);
        int yGroupSize = parentToGroupSize.get(yParent);
        // parentToGroupSize.remove(xParent);
        // parentToGroupSize.remove(yParent);

        groupSize.put(xGroupSize, groupSize.get(xGroupSize) - 1);
        groupSize.put(yGroupSize, groupSize.get(yGroupSize) - 1);
        
        int totalSize = xGroupSize + yGroupSize;
        groupSize.put(totalSize, groupSize.getOrDefault(totalSize, 0) + 1);

        if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
            parentToGroupSize.put(xParent,totalSize);
        }else if(rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
            parentToGroupSize.put(yParent,totalSize);
        }else {
            parent[xParent] = yParent;
            parentToGroupSize.put(yParent,totalSize);
            rank[yParent]++;
        }
    }

    public int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }


}


class Solution {
    public int findLatestStep(int[] nums, int m) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        DSU dsu = new DSU(n);
        int lastStep = -1;


        for(int i=0; i<n; i++) nums[i]--;
        
        for(int i=0; i<n; i++) {
            int num = nums[i];
            int prev = num - 1 ;
            int next = num + 1;
            if(!dsu.parentToGroupSize.containsKey(num)) {
                dsu.parentToGroupSize.put(num,1);
                dsu.groupSize.put(1, dsu.groupSize.getOrDefault(1,0) + 1);
            }

            if(prev >= 0 && visited[prev]) dsu.union(num, prev);
            if(next < n && visited[next]) dsu.union(num,next);

            visited[num] = true;

            
            if(dsu.groupSize.getOrDefault(m,0) > 0) {
                lastStep = i+1;
            }
            
            
        }
        return lastStep;
    } 
}
