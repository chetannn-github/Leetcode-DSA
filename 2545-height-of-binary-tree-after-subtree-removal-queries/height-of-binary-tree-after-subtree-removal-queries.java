class Solution {
    HashMap<Integer,Integer> nodeHeight = new HashMap<>();
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];
        HashMap<Integer,List<Integer>> queryMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            List<Integer> indices = queryMap.getOrDefault(queries[i],new ArrayList<>());
            indices.add(i);
            queryMap.put(queries[i],indices);
        }

        dfs(root);
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<Integer,Integer> levelHighest = new HashMap<>();
        HashMap<Integer,Integer> levelSecondHeight = new HashMap<>();
        int currLevel = 0;

        queue.add(root);
    
        while(!queue.isEmpty()) {
            int currSize = queue.size();
            int maxHeightNode = queue.peek().val;
            int maxHeight = nodeHeight.get(queue.peek().val);
            int secondHeight = -1;

            while(currSize-->0) {
                TreeNode curr = queue.remove();
                int currHeight = nodeHeight.get(curr.val);
                
                if(maxHeight < currHeight) {
                    secondHeight = maxHeight;
                    maxHeight = currHeight;
                    maxHeightNode = curr.val;

                    
                }else if(curr.val != maxHeightNode && secondHeight < currHeight) {
                    secondHeight = nodeHeight.get(curr.val);
                }

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            levelHighest.put(currLevel,maxHeightNode);
            levelSecondHeight.put(currLevel,secondHeight);
            currLevel++;
        }
        Arrays.fill(result,nodeHeight.get(root.val));

        for(int level : levelHighest.keySet()){
            int levelHighestNode = levelHighest.get(level);
            List<Integer> indices = queryMap.getOrDefault(levelHighestNode,null);
            if(indices == null) continue;
            int secondHighestHeight = levelSecondHeight.getOrDefault(level,0);
            int highestHeight = nodeHeight.get(levelHighestNode);
            for(int idx : indices) result[idx] -= (highestHeight - secondHighestHeight);

        }
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null) return -1;

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        int currHeight = 1 + Math.max(leftHeight,rightHeight);
        nodeHeight.put(root.val,currHeight);
        return currHeight;
    }
}