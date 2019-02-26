package com.cn.passself.lru;

import java.util.Hashtable;

/**
 * 参考:https://blog.csdn.net/qq_33824312/article/details/70244077
 * 双向链表+hashtable 实现原理
 *
 * 将cache的所有位置都用双向链表链接起来，当一个被命中后，就将该位置调整到链表头的位置，
 * 新加入的Cache直接加到链表头中。这样在多次进行Cache操作后，最近被命中的，就会被向链表头方向移动
 * 而没有命中的，则向链表后面移动，链表尾则表示最近最少使用的Cache。当需要替换内容时候，链表的最后位置
 * 就是被命中的位置。只需要淘汰链表最后部分即可.
 */
public class LRULinkedHashTable {
    private int cacheSize;
    private Hashtable nodes;//缓存容器
    private int currentSize;
    private Entry first;//链表头
    private Entry last;//链表尾

    public LRULinkedHashTable(int maxSize){
        currentSize = 0;
        cacheSize = maxSize;
        nodes = new Hashtable(cacheSize);
    }

    public Entry get(Object key){
        Entry node = (Entry) nodes.get(key);
        if (node != null){
            moveToHead(node);
            return node;
        }else{
            return null;
        }
    }

    public void put(Object key,Object value){
        Entry entry = (Entry) nodes.get(key);
        if (entry == null){
            if (currentSize >= cacheSize){
                nodes.remove(last.key);
                removeLast();
            }else {
                currentSize++;
            }
            entry = new Entry();
        }
        entry.value = value;
        //将最新使用的节点放到链表头，表示最新使用的
        moveToHead(entry);
        nodes.put(key,entry);
    }

    /**
     * 只有cache满了才会被执行删除
     * @param key
     */
    public void remove(Object key){
        Entry node = (Entry) nodes.get(key);
        //在链表中删除
        if (node!= null){
            node.prev.next = node.next;
        }
        if (node.next != null){
            node.next.prev = node.prev;
        }
        if (last == node){
            last = node.prev;
        }
        if (first == node){
            first = node.next;
        }
        //在hashtable中删除
        nodes.remove(key);
    }

    /**
     * 删除最后一个
     */
    private void removeLast(){
        if (last != null){
            if (last.prev!= null){
                last.prev.next = null;
            }else {
                first = null;
            }
            last = last.prev;
        }
    }

    /**
     * 移动到链表头，表示这个节点是最新使用过的
     * @param node
     */
    private void moveToHead(Entry node){
        if (node== first){
            return;
        }
        if (node.prev != null){
            node.prev.next = node.next;
        }
        if (node.next != null){
            node.next.prev = node.prev;
        }
        if (last == node){
            last = node.prev;
        }
        if (first != null){
            node.next = first;
            first.prev = node;
        }
        first = node;
        node.prev = null;
        if (last == null){
            last = first;
        }
    }

    /**
     * 清空缓存
     */
    public void clear(){
        first = null;
        last = null;
        currentSize = 0;
    }
}

class Entry{
    Entry prev;//前一节点
    Entry next;//后一节点
    Object value;//值
    Object key;//键
}
