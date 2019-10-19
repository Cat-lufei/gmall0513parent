package com.atguigu.gmall0513.mock.util; /**
 * Created by LuFei on 2019/10/18
 * Author: LuFei
 */
import java.util.Random;

public class RandomNum {
    public static final  int getRandInt(int fromNum,int toNum){
        return   fromNum+ new Random().nextInt(toNum-fromNum+1);
    }
}
