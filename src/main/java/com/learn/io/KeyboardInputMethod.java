package com.learn.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author: lxj
 * @Date: 2020/5/28
 * @Description:
 */

public class KeyboardInputMethod {

    public static void main(String[] args){
//        scannerInput();
        readInput();
    }

    public static void scannerInput(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("请输入：");
            String input = scanner.next();
            System.out.println("输入内容：" + input);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }

    public static void readInput(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请输入：");
            String input = bufferedReader.readLine();
            System.out.println("输入内容：" + input);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
