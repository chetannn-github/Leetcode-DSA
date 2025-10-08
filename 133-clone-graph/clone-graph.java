class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        Node mainNode = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer,Node>  map = new HashMap<>();

        queue.add(node);
        map.put(mainNode.val,mainNode);
        
        while(!queue.isEmpty()) {
            Node curr = queue.remove();
            Node copied = map.get(curr.val);

            for (Node nbr : curr.neighbors) {
                if(!map.containsKey(nbr.val)) {
                    map.put(nbr.val, new Node(nbr.val));
                    queue.add(nbr);
                }
                copied.neighbors.add(map.get(nbr.val));
            }
        }

        return mainNode;
    }    
}