import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>(16,0.75f,true);
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        map.get("banana");
        map.get("apple");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }



    public static void main1(String[] args) {
        LRUCache1 lru = new LRUCache1(2);
        lru.put(1, 1);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
    }
}

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
