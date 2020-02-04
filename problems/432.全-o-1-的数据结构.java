/*
 * @lc app=leetcode.cn id=432 lang=java
 *
 * [432] 全 O(1) 的数据结构
 *
 * https://leetcode-cn.com/problems/all-oone-data-structure/description/
 *
 * algorithms
 * Hard (34.97%)
 * Likes:    29
 * Dislikes: 0
 * Total Accepted:    2.1K
 * Total Submissions: 6.1K
 * Testcase Example:  '["AllOne","getMaxKey","getMinKey"]\n[[],[],[]]'
 *
 * 实现一个数据结构支持以下操作：
 * 
 * 
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key
 * 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 
 * 
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 * 
 */

// @lc code=start
class AllOne {

    class Node {
        int v;
        Set<String> keys;
        Node prev, next;
        public Node(int value) {
            v = value;
            keys = new HashSet<>();
        }
    }

    Map<String, Integer> keyMaps = new HashMap<>();
    Map<Integer, Node> valueMaps = new HashMap<>();
    Node head = new Node(0);
    Node tail = new Node(0);

    /** Initialize your data structure here. */
    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyMaps.containsKey(key)) {
            int val = keyMaps.get(key);
            keyMaps.put(key, val + 1);
            Node node = valueMaps.get(val);
            node.keys.remove(key);
            Node preNode = node.prev;
            if (preNode == head || preNode.v > val + 1) {
                Node newNode = new Node(val + 1);
                newNode.keys.add(key);
                newNode.next = node;
                newNode.prev = preNode;
                preNode.next = newNode;
                node.prev = newNode;
                valueMaps.put(val + 1, newNode);
                preNode = newNode;
            } else {
                preNode.keys.add(key);
            }
            if (node.keys.size() == 0) {
                preNode.next = node.next;
                node.next.prev = preNode;
                valueMaps.remove(val);
            }
        } else {
            keyMaps.put(key, 1);
            if (valueMaps.containsKey(1)) {
                valueMaps.get(1).keys.add(key);
            } else {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                newNode.next = tail;
                newNode.prev = tail.prev;
                tail.prev.next = newNode;
                tail.prev = newNode;
                valueMaps.put(1, newNode);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!keyMaps.containsKey(key)) {
            return;
        }
        int val = keyMaps.get(key);
        Node node = valueMaps.get(val);
        node.keys.remove(key);
        if (val == 1) {
            keyMaps.remove(key);
        } else {
            keyMaps.put(key, val - 1);
            Node nextNode = node.next;
            if (nextNode == tail || nextNode.v < val - 1) {
                Node newNode = new Node(val - 1);
                newNode.keys.add(key);
                newNode.prev = node;
                newNode.next = nextNode;
                node.next = newNode;
                nextNode.prev = newNode;
                valueMaps.put(val - 1, newNode);
            } else {
                nextNode.keys.add(key);
            }
        }
        if (node.keys.size() == 0) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            valueMaps.remove(val);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head.next == tail) {
            return "";
        } else {
            return head.next.keys.iterator().next();
        }
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            return tail.prev.keys.iterator().next();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// @lc code=end

