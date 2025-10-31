public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        dfs(root,data);
        return data.toString();
    }

    private void dfs(TreeNode curr,StringBuilder data) {
        if(curr == null) {
            data.append("NULL,");
            return;
        }

        data.append(curr.val+",");
        dfs(curr.left,data);
        dfs(curr.right,data);
    }
    int idx = 0;
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] info = data.split(",");
        return solve(info);
    }
    
    
    public TreeNode solve(String[] info) {
        if(idx >= info.length || info[idx].equals("NULL")) {
            idx++;
            return null;
        }
        TreeNode curr = new TreeNode(Integer.parseInt(info[idx++]));
        curr.left = solve(info);
        curr.right = solve(info);
        return curr;
    }

}
