package com.learn.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: lxj
 * @Date: 2020/5/11
 * @Description:
 */

public class GamePlayerDynamicProxy implements InvocationHandler {
    //被代理的实例
    private Object object;
    //我要代理谁
    public GamePlayerDynamicProxy(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.object, args);
    }

    public static void main(String[] args) {
        IGamePlayer iGamePlayer = new GamePlayer("张翰");
        ClassLoader classLoader = iGamePlayer.getClass().getClassLoader();
        IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, new GamePlayerDynamicProxy(iGamePlayer));
        proxy.login("zhanghan", "ss");
        proxy.killBoss();
        proxy.upGrade();
    }
}
