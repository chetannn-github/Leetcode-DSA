class Solution {
    StringBuilder ans;
    public String smallestFromLeaf(TreeNode root) {
        ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('a' + root.val));
        dfs(root,sb);

        return ans.reverse().toString();
    }

    public void dfs(TreeNode root, StringBuilder sb){
        if(root.left == null && root.right == null){
            updateAns(sb);
            return;
        }

        if(root.left != null){
            sb.append((char) ('a' + root.left.val));
            dfs(root.left,sb);
            sb.setLength(sb.length()-1);
        }
        if(root.right != null){
            sb.append((char) ('a' + root.right.val));
            dfs(root.right,sb);
            sb.setLength(sb.length()-1);
        }
    }

    public void updateAns(StringBuilder sb){
        // System.out.println(sb.toString());
        int ansLength = ans.length();
        if(ansLength==0){
            ans = new StringBuilder(sb);
            return;
        }
        int size = sb.length();

        for(int i=0; i<Math.max(ansLength,size); i++){
            if(i>=ansLength) break;
            else if(i>= size) {ans = new StringBuilder(sb);break;}
            if(sb.charAt(size-1-i) == ans.charAt(ansLength-1-i)){
                continue;
            }else if(sb.charAt(size-1-i) < ans.charAt(ansLength-1-i)){
                ans = new StringBuilder(sb);
                break;
            }else{break;}
        }
    
        
    }
}