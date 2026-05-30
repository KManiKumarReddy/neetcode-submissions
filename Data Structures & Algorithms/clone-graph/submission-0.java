/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        Node[] clonedNodes = new Node[100];
        for(int i = 0; i < 100; i ++){
            clonedNodes[i] = null;
        }
        q.offer(node);
        clonedNodes[0] = new Node(1);
        while(!q.isEmpty()){
            Node current = q.poll();
            for(Node i : current.neighbors ){
                if(clonedNodes[i.val-1] == null){
                    clonedNodes[i.val-1] = new Node(i.val);
                    q.offer(i);
                }
                clonedNodes[current.val-1].neighbors.add(clonedNodes[i.val-1]);
            }
        }
        return clonedNodes[0];
    }
}