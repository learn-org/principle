package com.learn.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lxj
 * @Date: 2021/6/23
 * @Description: 被观察者
 */

public class Subject {

    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObserver() {
        if (observerList != null && !observerList.isEmpty()) {
            observerList.forEach(Observer::sendMessage);
        }
    }
}
