package com.learn.designmode.proxy;

/**
 * @author: lxj
 * @Date: 2020/5/11
 * @Description:
 */

public class GamePlayerProxy implements IGamePlayer{
    private IGamePlayer iGamePlayer;
    public GamePlayerProxy(IGamePlayer iGamePlayer){
        this.iGamePlayer = iGamePlayer;
    }

    @Override
    public void login(String userName, String password) {
        iGamePlayer.login(userName, password);

    }

    @Override
    public void killBoss() {
        iGamePlayer.killBoss();
    }

    @Override
    public void upGrade() {
        iGamePlayer.upGrade();
    }

    public static void main(String[] args) {
        IGamePlayer iGamePlayer = new GamePlayer("张三");
        iGamePlayer.login("张三", "ss");
        iGamePlayer.killBoss();
        iGamePlayer.upGrade();
        System.out.println("##################################################");
        IGamePlayer gamePlayer = new GamePlayerProxy(iGamePlayer);
        gamePlayer.login("张三", "ss");
        gamePlayer.killBoss();
        gamePlayer.upGrade();
    }
}
