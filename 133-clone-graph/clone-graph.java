class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        HashMap<Integer,Node> copy = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
    
    
        Node mainNode = new Node(node.val);
        queue.add(node);
        copy.put(node.val,mainNode);

        while(!queue.isEmpty()){
            Node curr = queue.remove();
            Node copied = copy.get(curr.val);

            for(Node nb : curr.neighbors){
                int val = nb.val;

                if(!copy.containsKey(val)){
                    copy.put(val,new Node(val));
                    queue.add(nb);
                }
                copied.neighbors.add(copy.get(val));

            }
        }

        return mainNode;
    
    }    
}