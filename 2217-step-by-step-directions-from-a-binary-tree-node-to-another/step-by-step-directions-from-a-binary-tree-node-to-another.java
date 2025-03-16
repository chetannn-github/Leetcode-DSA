class Solution {
    HashMap<TreeNode,TreeNode> hm;
    TreeNode startNode;
    HashSet<Integer> hs;
    String dirn;
    StringBuilder temp;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        hm = new HashMap<>();
        hs = new HashSet<>();
        temp = new StringBuilder();

        dfs(root,startValue);
        modifiedDFS(startNode,destValue);

        hs.add(startNode.val);
        return dirn;
    }

    public void dfs(TreeNode root,int startValue){
        if(root == null) return;
        if(root.val == startValue){
            startNode = root;
        }
        if(root.left != null){
            hm.put(root.left,root);
            dfs(root.left,startValue);
        }
        if(root.right != null){
            hm.put(root.right,root);
            dfs(root.right,startValue);
        }
    }

    public void modifiedDFS(TreeNode root,int destValue){
        if(root == null) return;
        if(root.val == destValue){
            if(dirn == null || dirn.length() > temp.length()){
                dirn = temp.toString();
            }
            return;
        }

        if(root.left != null && !hs.contains(root.left.val)){
            // L
            temp.append("L");
            hs.add(root.left.val);
            modifiedDFS(root.left,destValue);
            hs.remove(root.left.val);
            temp.setLength(temp.length()-1);
        }
        if(root.right != null && !hs.contains(root.right.val)){
            // R
            temp.append("R");
            hs.add(root.right.val);
            modifiedDFS(root.right,destValue);
            temp.setLength(temp.length()-1);
            hs.remove(root.right.val);
        }

        if(hm.containsKey(root) && !hs.contains(hm.get(root).val)){
            hs.add(hm.get(root).val);
            temp.append("U");
            // U
            modifiedDFS(hm.get(root),destValue);
            temp.setLength(temp.length()-1);
            hs.remove(hm.get(root).val);
        }
    }
}