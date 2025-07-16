package main.common;
import java.util.*;

public class LFUCache {

    private static class Node{
        int key;
        int value;
        int freq;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq=1;
        }
    }

    int minFreq;
    int capacity;
    Map<Integer,Node> keyToNode;
    Map<Integer,LinkedHashSet<Integer>> freqToKeys;
    public LFUCache(int capacity){
        this.capacity=capacity;
        this.minFreq=0;
        this.keyToNode =new HashMap<>();
        this.freqToKeys=new HashMap<>();
    }

    int get(int key){

        if(keyToNode.containsKey(key)){
            Node node=keyToNode.get(key);
            updateFrequency(node);
            return node.value;

        }
        return -1;
    }
    void put(int key,int value){

        if(keyToNode.containsKey(key)){
            Node node=keyToNode.get(key);
            node.value=value;
            updateFrequency(node);
        }else{
            if(keyToNode.size()>=capacity){

                LinkedHashSet<Integer> minFreqKeys=freqToKeys.get(minFreq);
                int keyToRemove=minFreqKeys.iterator().next();
                minFreqKeys.remove(keyToRemove);
                if(minFreqKeys.isEmpty())freqToKeys.remove(minFreq);
                keyToNode.remove(keyToRemove);
            }
            Node newNode=new Node(key,value);
            keyToNode.put(key,newNode);
            freqToKeys.computeIfAbsent(1,k->new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }

    }

    void updateFrequency(Node node){

        int oldFreq=node.freq;
        LinkedHashSet<Integer> keysWithThisFreq=freqToKeys.get(oldFreq);
        keysWithThisFreq.remove(node.key);
        if(keysWithThisFreq.isEmpty()){
            freqToKeys.remove(oldFreq);
            if(oldFreq==minFreq)minFreq+=1;
        }
        node.freq+=1;
        freqToKeys.computeIfAbsent(node.freq,k->new LinkedHashSet<>()).add(node.key);

    }

    // Main method to test the LFU cache
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1

        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3

        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
