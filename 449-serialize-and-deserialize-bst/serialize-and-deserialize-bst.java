public class Codec {
    StringBuilder sb;
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        preorder(root);
        return sb.toString();
    }

    public void preorder(TreeNode root){
        if(root == null) return;

        if(sb.length() == 0){
            sb.append(root.val);
        }else{
            sb.append("-"+root.val);
        }

        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        System.out.println(data);
        String[] nodes = data.split("-");
        int n = nodes.length;
        int[] in = new int[n];

        for(int i=0; i<n; i++){
            String node = nodes[i];
            int length = node.length();
            int numericNode = 0;
            int p = 0;
            while(p != length){
                numericNode = numericNode * 10 + ( node.charAt(p) - '0');
                p++;
            }
            in[i] = numericNode;
        }

        return solve(in,0,n-1);
    }

    public TreeNode solve(int[] preorder,int start, int end){
        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[start]);
        // root se chote wale kha tk aarhe hh
        int leftMost = start;
        for(int i=start+1; i<=end; i++){
            if(preorder[i] < preorder[start]){
                leftMost = i;
            }else{
                break;
            }
        }

        root.left = solve(preorder,start+1,leftMost);
        root.right = solve(preorder,leftMost+1,end);
        return root;
    }



    
}

