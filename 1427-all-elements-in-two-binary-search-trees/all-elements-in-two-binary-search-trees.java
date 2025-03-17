// class Solution { 
//     public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
//         List<Integer> list = new ArrayList<>();
        
//         inorder(root1,list);
//         inorder(root2,list);

//         Collections.sort(list);
//         return list;
//     }

//     public void inorder(TreeNode root,List<Integer> list){
//         if(root == null ) return;

//         inorder(root.left,list);
//         list.add(root.val);
//         inorder(root.right,list);
//     }

// }

class Solution {
public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        inOrder1(root1, queue);
        inOrder2(root2, queue, res);
        res.addAll(queue);
        return res;
    }
    void inOrder1(TreeNode node, Queue<Integer> queue) {
        if(node==null) return;
        inOrder1(node.left, queue);
        queue.offer(node.val);
        inOrder1(node.right, queue);
    } 
    void inOrder2(TreeNode node, Queue<Integer> queue, List<Integer> res) {
        if(node==null) return;
        inOrder2(node.left, queue, res);
        while(!queue.isEmpty() && queue.peek()<=node.val) {
            res.add(queue.poll());
        }
        res.add(node.val);
        inOrder2(node.right, queue, res);
    }
}