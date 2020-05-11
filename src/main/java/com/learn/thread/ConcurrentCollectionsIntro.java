package com.learn.thread;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author： lxj
 * @date： 2019/12/4
 * @description：
 */
public class ConcurrentCollectionsIntro {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        BlockingQueue blockingQueue = new BlockingQueue() {
            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean offer(Object o) {
                return false;
            }

            @Override
            public void put(Object o) throws InterruptedException {

            }

            @Override
            public boolean offer(Object o, long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public Object take() throws InterruptedException {
                return null;
            }

            @Override
            public Object poll(long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public int remainingCapacity() {
                return 0;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public int drainTo(Collection c) {
                return 0;
            }

            @Override
            public int drainTo(Collection c, int maxElements) {
                return 0;
            }

            @Override
            public Object remove() {
                return null;
            }

            @Override
            public Object poll() {
                return null;
            }

            @Override
            public Object element() {
                return null;
            }

            @Override
            public Object peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        Collections.synchronizedMap(new HashMap<>());
        Collections.synchronizedList(new ArrayList<>());
    }
}
