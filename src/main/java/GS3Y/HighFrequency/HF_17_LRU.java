package GS3Y.HighFrequency;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

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

    public static void main(String[] args) {
        
    }
}
