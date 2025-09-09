// class Solution {
//     public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         for(int i=0; i<n; i++){
//             if(leftChild[i]== -1 && rightChild[i] == -1) continue;
//             if(hm.containsKey(leftChild[i]) || hm.containsKey(rightChild[i])){
//                 return false; // ek child ke two parents
//             }
//             if(hm.containsKey(i) && (hm.get(i) == leftChild[i] ||hm.get(i) == rightChild[i] )){
//                 return false; // cycle detection
//             }
            
//             if(leftChild[i] != -1) hm.put(leftChild[i],i);
//             if(rightChild[i] != -1) hm.put(rightChild[i],i);
        
//         }
//         int root = -1;

//         for(int i=0; i<n; i++){
//             if(!hm.containsKey(i)){
//                 if(root == -1 ) root = i;
//                 else return false; // two roots
//             }
//         }

//         if(root == -1) return false;

//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(root);
//         int count = 0;

//         while(!queue.isEmpty()){
//             int curr = queue.remove();
//             count++;

//             if(leftChild[curr] != -1) queue.add(leftChild[curr]);
//             if(rightChild[curr] != -1) queue.add(rightChild[curr]);
//         }
        
//         return count ==n;

        
//     }
// }


class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];
        for(int i=0; i<n; i++) {
            if(leftChild[i] != -1) {
                indegree[leftChild[i]]++;
                if(indegree[leftChild[i]] > 1) return false;
            }

            if(rightChild[i] != -1) {
                indegree[rightChild[i]]++;
                if(indegree[rightChild[i]] > 1) return false;
            }
        }

        // sirf ek root hona Chaiye 
        boolean rootFound = false;
        int root = -1;
        for(int i=0; i<n; i++) {
            int in = indegree[i];
            if(in == 0) {
                if(rootFound) return false;
                rootFound = true;
                root = i;
            }
        }

        if(root == -1) return false;
        

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
    

        while(!queue.isEmpty()){
            int curr = queue.remove();
            count++;

            if(leftChild[curr] != -1) queue.add(leftChild[curr]);
            if(rightChild[curr] != -1) queue.add(rightChild[curr]);


            if(count > n) return false;
        }
        
        return count == n;

        
    }
}