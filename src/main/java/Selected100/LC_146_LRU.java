package Selected100;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC_146_LRU {

    /**
     * 自行实现一个LinkedHashMap
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {


        private int capacity;       //如果多个key-value的使用次数相同，则需要排除最旧的那个

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        /**
         * 重写“移除 年龄最大 的Map< K,V >对象”
         * 只要为true则生效
         * */
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > this.capacity;
        }
    }

}
