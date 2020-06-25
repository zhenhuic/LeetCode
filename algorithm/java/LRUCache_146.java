import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 基于 Java 自带的 LinkedHashMap 实现
 */
public class LRUCache_146 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache_146(int capacity) {
        // accessOrder 为 true，默认是 insertion-order
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * 哈希表 + 双向链表
 * 对于 get 操作，首先判断 key 是否存在：
 *   如果 key 不存在，则返回 -1；
 *   如果 key 存在，则 key 对应的节点是最近被使用的节点。
 *   通过哈希表定位到该节点在双向链表中的位置，
 *   并将其移动到双向链表的头部，最后返回该节点的值。
 * 对于 put 操作，首先判断 key 是否存在：
 *   如果 key 不存在，使用 key 和 value 创建一个新的节点，
 *   在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。
 *   然后判断双向链表的节点数是否超出容量，如果超出容量，
 *   则删除双向链表的尾部节点，并删除哈希表中对应的项；
 *   如果 key 存在，则与 get 操作类似，先通过哈希表定位，
 *   再将对应的节点的值更新为 value，并将该节点移到双向链表的头部。
 */
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            ++size;
            if (size > capacity) {
                DLinkedNode rm =  removeTail();
                cache.remove(rm.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void moveToHead(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private DLinkedNode removeTail() {
        DLinkedNode rm = tail.prev;
        removeNode(rm);
        return rm;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
