package com.learn.designmode.proxy;

/**
 * @author: lxj
 * @Date: 2020/5/11
 * @Description:
 */

public class GamePlayer implements IGamePlayer{
    private String playName;
    public GamePlayer(String playName){
        this.playName = playName;
    }

    @Override
    public void login(String userName, String password) {
        System.out.println(playName + "登录了！");

    }

    @Override
    public void killBoss() {
        System.out.println(playName + "在打怪！");
    }

    @Override
    public void upGrade() {
        System.out.println(playName + "升级了！");
    }
}
