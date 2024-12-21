import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    static Map<Integer, Node> map = new HashMap<>();

    static int capacity = 4;
    static Node head = new Node(-1, -1);
    static Node tail = new Node(-1, -1);

    LRUCache(int capacity){
        this.capacity = capacity;
        map.clear();
        head.next = tail;
        tail.prev = head;
    }

    public static void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public static void insertAfterHead(Node node){
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }

    public static int get(int key){
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);

        return node.value;
    }

    public static void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(map.size() == capacity){
                Node leastUsed = tail.prev;
                map.remove(leastUsed.key);
                deleteNode(leastUsed);
            }

            Node node = new Node(key, value);
            map.put(node.key, node);
            insertAfterHead(node);
        }
    }

    public static void main(String[] args) {

    }
}






























