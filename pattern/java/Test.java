import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache1 {
    private int capacity;
    private int size;
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> cache;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
        } else {
            node.value = value;
            moveToHead(node);
        }
        if (size > capacity) {
            removeTail();
        }
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void moveToHead(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode rm = tail.prev;
        rm.prev.next = tail;
        tail.prev = rm.prev;
        size--;
        return rm;
    }

    class DLinkedNode {
        Integer key;
        Integer value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
