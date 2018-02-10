package com.zga.test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2017-11-30 17:35
 */
public abstract class Animal {

    public void sleep(){
        System.out.println("Animal sleep");
        eat();
    }


    public abstract void eat();
}
