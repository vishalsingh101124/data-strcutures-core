package main.common;

import java.util.HashMap;
import java.util.Map;

public class LRUCustom {

    static class Node {
        int data;
        int key;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
        }

    }
    private Node head;
    private Node tail;
    int capacity;
    private Map<Integer,Node> cache;

    public LRUCustom(int capacity) {
        this.capacity = capacity;
        cache=new HashMap<>();
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.prev=head;
    }

    int getKey(int key){
        Node node=cache.get(key);
        int result=-1;
        if(node!=null){

            result=node.data;
            deleteNode(node);
            addNode(node);

        }

        return result;
    }

    void put(int key,int value){
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            deleteNode(node);
            node.data=value;
            node.key=key;
            addNode(node);

        }else{
            if(cache.size()>=capacity){
                Node removeNode=tail.prev;
                deleteNode(removeNode);
                cache.remove(removeNode.key);
            }
            Node node=new Node(value);
            node.key=key;
            addNode(node);
            cache.put(key,node);
        }
    }

    void addNode(Node node){
        Node headNext=head.next;

        headNext.prev=node;
        node.next=headNext;

        node.prev=head;
        head.next=node;

    }

    void deleteNode(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;

    }

    public static void main(String[] args) {
        LRUCustom lruCustom=new LRUCustom(3);

        lruCustom.put(11,111);
        lruCustom.put(12,112);
        lruCustom.put(13,113);

        System.out.println(lruCustom.getKey(11));
        lruCustom.put(23,234);
        System.out.println(lruCustom);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int key:cache.keySet()){
            sb.append("key ").append(key).append(" value ").append(cache.get(key).data);
            sb.append("\n");
        }
        return sb.toString();
    }



}
