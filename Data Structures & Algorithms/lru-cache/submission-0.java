class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> map = new HashMap<>();
    int limit;

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode) {
        Node oldNode = head.next;
        head.next = newNode;
        newNode.prev = head;

        oldNode.prev = newNode;
        newNode.next = oldNode;
    }

    public void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node ansNode = map.get(key);
        int ans = ansNode.val;

        map.remove(key);
        deleteNode(ansNode);

        map.put(key, ansNode);
        addNode(ansNode);

        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(key);
            deleteNode(node);
        }

        if(limit == map.size()) {
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
        }

        Node node = new Node(key, value);
        addNode(node);
        map.put(key, node);
    }
}
