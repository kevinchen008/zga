package com.zga.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2017-11-30 17:38
 */
public class Test {
    public static void main(String[] args){
      /*  Animal A = new Cat();
        A.sleep();

*/
        List<String> stringList  = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.forEach(item->System.out.println(item));

        stringList.forEach(item->{
            if("b".equals(item)){
                System.out.println(item);
            }
        });

    }
}
