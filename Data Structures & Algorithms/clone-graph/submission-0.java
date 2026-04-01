/*
Definition for a Node.
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
        if(node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node result = new Node(node.val);
        visited.put(node, result);
        q.add(node);

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(Node neighbour : cur.neighbors){
                if(!visited.containsKey(neighbour)){
                    visited.put(neighbour, new Node(neighbour.val));
                    q.add(neighbour);
                }
                visited.get(cur).neighbors.add(visited.get(neighbour));
            }
        }
        return result;
    }
}