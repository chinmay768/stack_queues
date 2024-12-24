import java.util.*;
public class LFUCache {

    int minimumFrequency;
    int capacity;
    private final Map<Integer, Node> cache; // The map to store the key-node pairs
    private final Map<Integer, DoublyLinkedList> frequencyMap;

    LFUCache(){
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key){
        if (capacity == 0) {
            return -1;
        }
        if(!cache.containsKey(key)){
            return -1;
        }

        Node node = cache.get(key);
        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value){
        if (capacity == 0) {
            return;
        }
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            increaseFrequency(node);
            return;
        }

        if(cache.size() == capacity){
            DoublyLinkedList leastFreqList = frequencyMap.get(minimumFrequency);
            Node toRemove = leastFreqList.removeLast();
            cache.remove(toRemove.key);
        }

        Node newNode = new Node(key, value);
        addNodeToFrequencyList(newNode);
        cache.put(key, newNode);
        minimumFrequency = 1;
    }

    public void increaseFrequency(Node node){
        int currFrequency = node.frequency;
        DoublyLinkedList currList = frequencyMap.get(currFrequency);
        currList.remove(node);

        if(currList.isEmpty()){
            frequencyMap.remove(currFrequency);
            if(currFrequency == minimumFrequency){
                minimumFrequency++;
            }
        }

        node.frequency++;
        addNodeToFrequencyList(node);
    }

    public void addNodeToFrequencyList(Node node){
        int newFrequency = node.frequency;
        DoublyLinkedList newFrequencyList = frequencyMap.getOrDefault(newFrequency, new DoublyLinkedList());
        newFrequencyList.addFirst(node);
        frequencyMap.put(newFrequency, newFrequencyList);
    }

    private static class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            frequency = 1;
        }
    }

    private static class DoublyLinkedList {
        // Node these variables must me private final and not static or else it won't work
        private final Node head;
        private final Node tail;

        DoublyLinkedList(){
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public Node remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
            return node;
        }

        public Node removeLast(){
            if(isEmpty()){
                return null;
            }
            return remove(tail.prev);
        }

        public boolean isEmpty() {
            // check if the list is empty by seeing if the dummy head is directly connected to the dummy tail
            return head.next == tail;
        }
    }

    public static void main(String[] args) {

    }
}
