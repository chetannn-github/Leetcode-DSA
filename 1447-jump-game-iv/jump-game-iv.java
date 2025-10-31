class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer,List<Integer>> valToIndices = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            List<Integer> indices = valToIndices.getOrDefault(arr[i],new ArrayList<>());
            indices.add(i);
            valToIndices.put(arr[i],indices);
        }

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);
        int steps = 0;

        while(!queue.isEmpty()) {
            int currSize = queue.size();
            while(currSize-->0) {
                int currIdx = queue.remove();

                if(currIdx == n-1) return steps;

                int next = currIdx + 1;
                int prev = currIdx - 1;

                if(next < n && !visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
                if(prev >= 0 && !visited.contains(prev)) {
                    queue.add(prev);
                    visited.add(prev);
                }
            
                if (valToIndices.containsKey(arr[currIdx])) {
                    for (int nbr : valToIndices.get(arr[currIdx])) {
                        if (!visited.contains(nbr)) {
                            queue.add(nbr);
                            visited.add(nbr);
                        }
                    }
                    valToIndices.remove(arr[currIdx]);
                }
            }

            steps++;
        }

        return -1;
    }
}