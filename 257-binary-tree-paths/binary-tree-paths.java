class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        return solve(root,paths,sb);
    }

    public List<String> solve(TreeNode root, List<String> paths,StringBuilder sb ){
        if(root == null){
            return paths;
        }
    
        if(root.left == null && root.right == null ){
            sb.append(root.val);
            paths.add(sb.toString());
            sb.setLength(sb.length()-1);
            return paths;
        }

        if(root.left != null){
            int size = sb.length();
            sb.append(root.val +"->");
            solve(root.left,paths,sb);
            sb.setLength(size);
        }

        if(root.right != null){
            int size = sb.length();
            sb.append(root.val+"->");
            solve(root.right,paths,sb);
            sb.setLength(size);
        }
        return paths;
        
    }
}