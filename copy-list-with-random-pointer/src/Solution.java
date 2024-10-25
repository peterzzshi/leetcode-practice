import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(final Node head) {
        final Map<Node, Node> nodeNodeMap = new HashMap<>();

        Node current = head;
        while (current != null) {
            nodeNodeMap.put(current, new Node(current.val));
            current = current.next;
        }
        Node result = head;
        while (result != null) {
            nodeNodeMap.get(result).next = nodeNodeMap.get(result.next);
            nodeNodeMap.get(result).random = nodeNodeMap.get(result.random);
            result = result.next;
        }
        return result;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(final int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
