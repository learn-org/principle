package com.learn.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author： lxj
 * @date： 2019/7/16
 * @description：
 */
public class MapRealize {

    public static void main(String[] args) {
        HashMap hashMap=new HashMap();
        hashMap.put("","");
        hashMap.get("");
        LinkedHashMap linkedHashMap=new LinkedHashMap();
        linkedHashMap.put("","");
        linkedHashMap.get("");
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put("","");
        concurrentHashMap.get("");
    }
}
