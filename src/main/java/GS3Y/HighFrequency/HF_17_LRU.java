package GS3Y.HighFrequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Slek
 * @Date 2023/1/10 22:41
 * @Description 实现一个LRU缓存
 * 1、LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * 2、int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * 3、void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class HF_17_LRU {


    /**
     * 思考过程
     * 首先想到要用队列，但是访问数据的时候，会将该值取出放在队头，如果采用队列的话，需要挨个pop，然后在push，不合理
     * 可以类比Redis，使用哈希表来存储键值对，键作为Key，值为Value并用Node封装为双向链表。这样即保证了查询效率O(1), 也实现了LRU的功能
     * 具体逻辑：
     * >> 插入：
     * 首先检查值是否存在，如果存在则直接返回，并将对应的Node移动到链表头
     * 如果不存在，则先检查链表容量。如果未达到容量，则将插入键值对到哈希表，并将Node移动到链表头(refresh)；如果已经达到容量，则移除队尾的Node(delete)，并插入键值对到哈希表，并将Node移动到链表头
     * >> 查询：
     * 如果不存在Key则直接返回-1；如果存在则返回对应的值，并将Node移动到链表头部(refresh)
     * 在双向链表的头尾增加哨兵节点
     */

    class LRUCache {
        /*用于封装Value，用双向链表实现LRU功能*/
        class Node {
            int key, value;
            Node left, right;

            Node(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        int CAPACITY;
        Node head, tail;
        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.CAPACITY = capacity;
            this.map = new HashMap<>();
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);

            head.right = tail;  //初始化头+尾两个哨兵节点；后续的节点都插入其中
            tail.left = head;
        }

        /*获取值*/
        public int get(int key) {
            if (this.map.containsKey(key)) {
                Node node = map.get(key);
                refresh(node);
                return node.value;
            }
            return -1;
        }

        /*插入值*/
        public void put(int key, int value) {
            Node node = null;
            if (this.map.containsKey(key)) {    //已存在，则直接更新node到链表头
                node = this.map.get(key);
                node.value = value;
            } else {
                if (this.map.size() == CAPACITY) {//如果已达到容量，则先移除队尾的node；再将新node插入链表头
                    //先移除队尾的元素
                    Node del = tail.left;
                    map.remove(del.key);
                    delete(del);
                }
                node = new Node(key, value);
                map.put(key, node);
            }
            refresh(node);  //最终更新node
        }


        /*更新Node,将其移动到链表头*/
        private void refresh(Node node) {
            delete(node);   //先移除node
            node.right = head.right;    //再头插到队头
            node.left = head;
            head.right.left = node;
            head.right = node;
        }

        /*移除Node*/
        private void delete(Node node) {
            if (node.left != null) {
                Node prev = node.left;
                prev.right = node.right;
                node.right.left = prev;
            }
        }
    }
}
