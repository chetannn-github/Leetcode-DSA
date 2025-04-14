class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer,Node> copy = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        visited.add(node.val);
    
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
                }
                copied.neighbors.add(copy.get(val));

                if(!visited.contains(val)) {
                    queue.add(nb);
                    visited.add(val);
                }
            }

            
           
        }

        return mainNode;
    
    }    
}