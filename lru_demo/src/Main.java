import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 测试用例 1: 基本 get 和 put 操作
        System.out.println("测试用例 1:");
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        System.out.println(cache1.get(1)); // 返回 1
        cache1.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(cache1.get(2)); // 返回 -1 (未找到)
        cache1.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(cache1.get(1)); // 返回 -1 (未找到)
        System.out.println(cache1.get(3)); // 返回 3
        System.out.println(cache1.get(4)); // 返回 4

        // 测试用例 2: 更新已有键的值
        System.out.println("\n测试用例 2:");
        LRUCache cache2 = new LRUCache(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        cache2.put(1, 10); // 更新 key=1 的值
        System.out.println(cache2.get(1)); // 返回 10
        System.out.println(cache2.get(2)); // 返回 2

        // 测试用例 3: 容量为 1 的缓存
        System.out.println("\n测试用例 3:");
        LRUCache cache3 = new LRUCache(1);
        cache3.put(1, 1);
        System.out.println(cache3.get(1)); // 返回 1
        cache3.put(2, 2); // 替换 key=1 的项
        System.out.println(cache3.get(1)); // 返回 -1
        System.out.println(cache3.get(2)); // 返回 2

        // 测试用例 4: 访问不存在的键
        System.out.println("\n测试用例 4:");
        LRUCache cache4 = new LRUCache(2);
        System.out.println(cache4.get(1)); // 返回 -1

        // 测试用例 5: 连续访问使最近最少使用的项被淘汰
        System.out.println("\n测试用例 5:");
        LRUCache cache5 = new LRUCache(3);
        cache5.put(1, 1);
        cache5.put(2, 2);
        cache5.put(3, 3);
        cache5.get(1); // 使 1 变为最近使用
        cache5.put(4, 4); // 淘汰 key=2
        System.out.println(cache5.get(2)); // 返回 -1
    }
}

class LRUCache{
    // 双向链表节点
    class DLinkedNode{
        int key,value;
        DLinkedNode prev,next;
        public DLinkedNode() {}
        public DLinkedNode(int key,int value){
            this.key=key;this.value=value;
        }
    }

    // map
    private Map<Integer,DLinkedNode>cache=new HashMap<>();
    // 当前大小
    private int size;
    // 当前容量
    private int capacity;
    // 头结点 尾巴节点
    private DLinkedNode head , tail;

    // 初始化LRU缓存
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // 获取key 再业务中类似于使用key
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    // 放入key-value
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 将节点添加到尾部
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 移除某个节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将某个节点提到链表的head 是在get()和put()操作后执行
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 移除尾部节点
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}