package main.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUInDetail extends LinkedHashMap<Integer,Integer> {

    private final int capacity;

    public LFUInDetail(int capacity) {
        super(capacity, 0.75f,true);
        this.capacity = capacity;
    }

    int get(int key){
        return super.getOrDefault(key,-1);
    }
    void put(int key,int value){
        super.put(key,value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LFUInDetail lfuInDetail=new LFUInDetail(5);

        lfuInDetail.put(1,20);
        lfuInDetail.put(11,21);
        lfuInDetail.put(12,22);
        lfuInDetail.put(13,23);
        lfuInDetail.put(14,24);

        System.out.println(lfuInDetail.get(1));
        System.out.println(lfuInDetail.get(1));

        System.out.println(lfuInDetail);
        lfuInDetail.put(56,65);
        System.out.println(lfuInDetail);





    }
}
